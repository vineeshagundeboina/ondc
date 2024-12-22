package com.splenta.gstreturns.service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashMap;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.splenta.gstreturns.pojo.request.EwaybillByIrn;

@Service
public class GenerateEwaybillByIrnService {
	
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		headers.set("Ocp-Apim-Subscription-Key", "AL1S2k5m3F9P2A7S0x");
		headers.set("Gstin", "07AGAPA5363L002");
		headers.set("user_name", "AL001");
		headers.set("AuthToken", "ad0KfLeCNdviLLKoVcyRU8IXR");

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		return headers;
	}
	
	public void ewaybillByIrn(EwaybillByIrn ewaybillByIrn,String sek) {
		String encodedMessage=getEncodedJsonObjectForProcessingEwaybillByIrn(ewaybillByIrn,sek);
		HttpHeaders headers=getHeaders();
		
		JSONObject requestPayload=new JSONObject();
		requestPayload.put("Data",encodedMessage);
		
		HttpEntity<String> entity=new HttpEntity<String>(requestPayload.toString(),headers);
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<String> responses=restTemplate.exchange("https://developers.eraahi.com/eInvoiceGateway/eiewb/v1.03/ewaybill",HttpMethod.POST,entity,String.class);
		JSONObject responseInJson=new JSONObject(responses.getBody());
		System.out.println("responseInJson------>"+responseInJson);
		
	}
	
	private String getEncodedJsonObjectForProcessingEwaybillByIrn(EwaybillByIrn ewaybillByIrn,String sek) {
		
		String encodedMessage="";
		JSONObject ewaybillMainObject=new JSONObject();
		try {
			Field changeMap = ewaybillMainObject.getClass().getDeclaredField("map");
			changeMap.setAccessible(true);
			changeMap.set(ewaybillMainObject, new LinkedHashMap<>());
			changeMap.setAccessible(false);
		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		ewaybillMainObject.put("Irn", ewaybillByIrn.getIrn());
		ewaybillMainObject.put("Distance", ewaybillByIrn.getDistance());
		ewaybillMainObject.put("TransMode", ewaybillByIrn.getTransMode());
		ewaybillMainObject.put("TransId", ewaybillByIrn.getTransId());
		ewaybillMainObject.put("TransName", ewaybillByIrn.getTransName());
		ewaybillMainObject.put("TrnDocDt", ewaybillByIrn.getTrnDocDt());
		ewaybillMainObject.put("TrnDocNo", ewaybillByIrn.getTrnDocNo());
		ewaybillMainObject.put("VehNo", ewaybillByIrn.getVehNo());
		ewaybillMainObject.put("VehType", ewaybillByIrn.getVehType());
		
		System.out.println("ewaybillMainObject--->"+ewaybillMainObject);
		
		String encodedJson=encodeBase64String(ewaybillMainObject.toString().getBytes());
		String encString=encryptBySymmetricKey(encodedJson, sek);
		encodedMessage = encString;
        return encodedMessage;
	
		
	}
	
	
	
	
	public String encryptBySymmetricKey(String jsondata, String decryptedsek) {
        try {
            byte[] dataToEncrypt = Base64.getDecoder().decode(jsondata);
            byte[] keyBytes = Base64.getDecoder().decode(decryptedsek);
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); // No initialization vector (IV) in this example
            byte[] encryptedData = cipher.doFinal(dataToEncrypt);
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception ex) {
            throw new RuntimeException("Encryption failed.", ex);
        }
    }

	final String CHARACTER_ENCODING = "UTF-8";

	byte[] decodeBase64StringTOByte(String stringData) throws Exception {
		return java.util.Base64.getDecoder().decode(stringData.getBytes(CHARACTER_ENCODING));
	}

	public String encodeBase64String(byte[] bytes) {
		return new String(java.util.Base64.getEncoder().encode(bytes));
	}
	
	
	

}
