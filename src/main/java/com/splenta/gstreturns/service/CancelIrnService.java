package com.splenta.gstreturns.service;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.SecretKey;

import java.lang.reflect.Field;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashMap;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.splenta.gstreturns.pojo.request.CancelIrnRequest;
import com.splenta.gstreturns.pojo.response.DecryptSekResponse;

@Service
public class CancelIrnService {
	
	@Autowired
	private EncryptionDecryptionService encryptionDecryptionService;

	private HttpHeaders getCancelIrnHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		headers.set("Ocp-Apim-Subscription-Key", "AL1S2k5m3F9P2A7S0x");
		headers.set("Gstin", "07AGAPA5363L002");
		headers.set("user_name", "AL001");
		headers.set("AuthToken", "ad0KfLeCNdviLLKoVcyRU8IXR");

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	public String cancelIRN(CancelIrnRequest cancelIrnRequest, String sek) {
        String finalResponse="";
		String encodedMessage = getEncodedJsonObjectForprocessCancelIrnRequst(cancelIrnRequest, sek);
		HttpHeaders headers = getCancelIrnHeaders();
		try {

			// System.out.println("encodedMessage: " + encodedMessage);
			JSONObject requestPayload = new JSONObject();

			requestPayload.put("Data", encodedMessage);
			//requestPayload.put("Data", "otLD941XaryQHL45unNjLW39Cd/W4gaMHiVNp/QZ8PFyHp7vVEoomlO4B0JhSWfSgFDCBsUO2vNM1i6KRwU9m8Wq9LjGCuM3dJsvPnw7JNle56stmi6AkCnETa2biDbQjFZdCoK22hLMLXXGFcK/YMWt5JoXPqx5G2EPEBV56Ec=\r\n");

			System.out.println("\n\n\n:");
			System.out.println(requestPayload);
			System.out.println("\n\n\n:");

			HttpEntity<String> entity = new HttpEntity<String>(requestPayload.toString(), headers);
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> responses = restTemplate.exchange(
					"https://developers.eraahi.com/eInvoiceGateway/eicore/v1.03/Invoice/Cancel", HttpMethod.POST, entity,
					String.class);
			JSONObject responseInJson = new JSONObject(responses.getBody());

			System.out.println("responseInJson: " + responseInJson.toString(4));
			
			String decryptedData = encryptionDecryptionService.getDecryptedRek(responseInJson.get("Data").toString(), decodeBase64StringTOByte(sek));
			finalResponse=new String(Base64.getDecoder().decode(decryptedData));
			System.out.println("after data -->" + new String(Base64.getDecoder().decode(decryptedData)));
//			String encryptedRek = responseInJson.getString("rek");
//			String encryptedData = responseInJson.getString("data");
//			System.out.println("before rek -->" + encryptedRek);
//			byte[] bytesek = encryptionDecryptionService.decodeBase64StringTOByte(sek);
//			String decryptedRek = encryptionDecryptionService.getDecryptedRek(encryptedRek, bytesek);
//			System.out.println("after rek -->" + decryptedRek);
//
//			System.out.println("before data -->" + encryptedData);
//			byte[] byterek = encryptionDecryptionService.decodeBase64StringTOByte(decryptedRek);
//			String decryptedData = encryptionDecryptionService.getDecryptedRek(encryptedData, byterek);
//			System.out.println("after data -->" + decryptedData);
			
			int status=responseInJson.getInt("Status");
			if(status==0) {
				throw new Exception("unable to cancel IRN");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return finalResponse;

	}

//	public String generateBase64Code(String cancelIRN) {
//		// Encode to Base64
//
//		String encodedString = Base64.getEncoder().encodeToString(cancelIRN.getBytes());
//		System.out.println("Encoded string: " + encodedString);
//		return encodedString;
//
//	}
//	
	private String getEncodedJsonObjectForprocessCancelIrnRequst(CancelIrnRequest cancelIrnRequest, String sek) {
		String encodedMessage = "";
		JSONObject cancelMainObject = new JSONObject();
		
		try {
			Field changeMap = cancelMainObject.getClass().getDeclaredField("map");
			changeMap.setAccessible(true);
			changeMap.set(cancelMainObject, new LinkedHashMap<>());
			changeMap.setAccessible(false);
		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		
		cancelMainObject.put("Irn", cancelIrnRequest.getIrn());
		cancelMainObject.put("CnlRsn", cancelIrnRequest.getCnlRsn());
		cancelMainObject.put("CnlRem", cancelIrnRequest.getCnlRem());
		
		System.out.println("cancelMainObject    ------>      "+cancelMainObject.toString(4));
		
		
		
		
		try {

			String encodedJson = encodeBase64String(cancelMainObject.toString().getBytes());

			String encString = encryptBySymmetricKey(encodedJson, sek);
            
			System.out.println("encString: " + encString);

			System.out.println("/n/n/n/n");
			System.out.println("base64convertedcode     " + encodedJson);
			System.out.println("/n/n/n/n");

			
			encodedMessage = encString;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encodedMessage;

	}

//	private String encryptBySymmetricKey(String encodedString, String decryptedSek) throws Exception {
//		byte[] sekByte = null;
//		try {
//			sekByte = decodeBase64StringTOByte(decryptedSek);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		System.out.println("SEKBYTEJHHHHHHHHHHHHHHHHHHHDS     " + new String(sekByte));
//
//		Key aesKey = new SecretKeySpec(sekByte, "AES");
//		try {
//			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//			cipher.init(Cipher.ENCRYPT_MODE, aesKey);
//			byte[] encryptedjsonbytes = cipher.doFinal(encodedString.getBytes());
//			String encryptedJson = encodeBase64String(encryptedjsonbytes);
//			return encryptedJson;
//		} catch (Exception e) {
//			return "Exception " + e;
//		}
//	}
	
	
	
	
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
	
	
	
	
//	
//	public String decryptBySymmetricKey(String encryptedSek, byte[] appKey) {
//		Key aesKey = new SecretKeySpec(appKey, "AES");
//		String response = "";
//		//DecryptSekResponse decryptSekResponse = new DecryptSekResponse();
//		try {
//			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//			cipher.init(Cipher.DECRYPT_MODE, aesKey);
//			byte[] encryptedSekBytes = Base64.getDecoder().decode(encryptedSek);
//			byte[] decryptedSekBytes = cipher.doFinal(encryptedSekBytes);
//			String decryptedSek = Base64.getEncoder().encodeToString(decryptedSekBytes);
//			response = decryptedSek;
//			//System.out.println("decryptedSek: " + decryptedSek);
//			//decryptSekResponse.setDecryptedSek(decryptedSek);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return response;
//	}
//	
	 public static String decryptBySymmetricKey(String encryptedSek, byte[] appKey) {
	        try {
	            byte[] dataToDecrypt = Base64.getDecoder().decode(encryptedSek);
	            SecretKey aesKey = new SecretKeySpec(appKey, "AES");
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            cipher.init(Cipher.DECRYPT_MODE, aesKey);
	            byte[] decryptedSekBytes = cipher.doFinal(dataToDecrypt);
	            return new String(decryptedSekBytes);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }


}
