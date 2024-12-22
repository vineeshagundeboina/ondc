package com.splenta.gstreturns.service;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashMap;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.splenta.gstreturns.pojo.request.AuthenticateRequest;
import com.splenta.gstreturns.pojo.response.AuthResponsePojo;
import com.splenta.gstreturns.pojo.response.WebClientResponse;

@Service
public class EwayInvoiceAuthService {

	@Value("${publicKey}")
	private String publicKey;

	private static Cipher ENCRYPT_CIPHER;
	private static Cipher DECRYPT_CIPHER;
	private static KeyGenerator KEYGEN;
	public static final String CHARACTER_ENCODING = "UTF-8";
	public static final String AES_TRANSFORMATION = "AES/ECB/PKCS5Padding";
	public static final String AES_ALGORITHM = "AES";
	public static final int ENC_BITS = 256;

	static {
		try {
			ENCRYPT_CIPHER = Cipher.getInstance(AES_TRANSFORMATION);
			DECRYPT_CIPHER = Cipher.getInstance(AES_TRANSFORMATION);
			KEYGEN = KeyGenerator.getInstance(AES_ALGORITHM);
			KEYGEN.init(ENC_BITS);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	Base64.Encoder encoder = Base64.getEncoder();

	static String generateSecureKey() {
		SecretKey secretKey = KEYGEN.generateKey();
		return encodeBase64String(secretKey.getEncoded());
	}

	private static String encodeBase64String(byte[] bytes) {
		return new String(java.util.Base64.getEncoder().encode(bytes));
	}

	byte[] decodeBase64StringTOByte(String stringData) throws Exception {
		return java.util.Base64.getDecoder().decode(stringData.getBytes(CHARACTER_ENCODING));
	}

	public WebClientResponse autheticateUser(AuthenticateRequest authenticateRequest) {
		WebClientResponse webCResponse = new WebClientResponse();
		try {
			String encoded_random32bit_key = generateSecureKey();

			authenticateRequest.setAppKey(encoded_random32bit_key);
			String encodedMessage = getEncodedJsonObject(authenticateRequest);

			System.out.println("\n" + encodedMessage + "\n");
			// Define the request headers
			HttpHeaders headers = getHeaders();
			JSONObject finalJsonRequest = new JSONObject();
			finalJsonRequest.put("Data", encodedMessage);
			try {

				HttpEntity<String> entity = new HttpEntity<String>(finalJsonRequest.toString(), headers);
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<String> responses = restTemplate.exchange(
						"https://developers.eraahi.com/eInvoiceGateway/eivital/v1.04/auth", HttpMethod.POST, entity,
						String.class);
				JSONObject responseInJson = new JSONObject(responses.getBody());
				webCResponse = getApiResponse(responseInJson);
				webCResponse.setOriginalAppKey(encoded_random32bit_key);
				System.out.println(responseInJson.toString(4));
				String decryptedSek = getDecryptedSek(webCResponse.getData().getSek(),
						decodeBase64StringTOByte(encoded_random32bit_key));
				webCResponse.setDecryptedSek(decryptedSek);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} catch (Exception e) {
			System.out.println("exception : " + e);
		}
		return webCResponse;

	}

	private String getEncodedJsonObject(AuthenticateRequest authenticateRequest) {
		String encodedMessage = "";
//		try {
//			JSONObject jsonData = new JSONObject(authenticateRequest);
//			byte[] base64EncodedData = encoder.encode(jsonData.toString().getBytes(StandardCharsets.UTF_8));
//			String finalContent = new String(base64EncodedData, StandardCharsets.UTF_8);
//			encodedMessage = encryptWithPublicKey(finalContent, publicKey);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		JSONObject jsonData = new JSONObject();
		try {
			try {
				Field changeMap = jsonData.getClass().getDeclaredField("map");
				changeMap.setAccessible(true);
				changeMap.set(jsonData, new LinkedHashMap<>());
				changeMap.setAccessible(false);
			} catch (IllegalAccessException | NoSuchFieldException e) {
				e.printStackTrace();
			}
			jsonData.put("UserName", authenticateRequest.getUserName());
			jsonData.put("Password", authenticateRequest.getPassword());
			jsonData.put("AppKey", authenticateRequest.getAppKey());
			jsonData.put("ForceRefreshAccessToken", authenticateRequest.isForceRefreshAccessToken());

			String base64EncodedData = encodeBase64String(jsonData.toString().getBytes(StandardCharsets.UTF_8));
			String finalContent = base64EncodedData;
			encodedMessage = encryptWithPublicKey(finalContent, publicKey);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return encodedMessage;
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		headers.set("Ocp-Apim-Subscription-Key", "AL1S2k5m3F9P2A7S0x");
		headers.set("Gstin", "07AGAPA5363L002");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	private WebClientResponse getApiResponse(JSONObject responseInJson) {
		WebClientResponse webCResponse = new WebClientResponse();
		webCResponse.setStatus(responseInJson.get("Status").toString());
		webCResponse.setData(getDataObject(responseInJson.getJSONObject("Data")));
		webCResponse.setErrorDetails(responseInJson.get("ErrorDetails").toString());
		webCResponse.setInfoDtls(responseInJson.get("InfoDtls").toString());
		return webCResponse;
	}

	private AuthResponsePojo getDataObject(JSONObject jsonObject) {
		System.out.println(jsonObject.toString());
		AuthResponsePojo authResponsePojo = new AuthResponsePojo();
		authResponsePojo.setAuthToken(jsonObject.getString("AuthToken"));
		authResponsePojo.setClientId(jsonObject.getString("ClientId"));
		authResponsePojo.setTokenExpiry(jsonObject.getString("TokenExpiry"));
		authResponsePojo.setSek(jsonObject.getString("Sek"));
		authResponsePojo.setUserName(jsonObject.getString("UserName"));
		return authResponsePojo;
	}

	public static String encryptWithPublicKey(String data, String publicKeyString) throws Exception {
		// Convert the public key string to a PublicKey object
		PublicKey publicKey = getPublicKeyFromString(publicKeyString);
		// Perform the encryption
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
		// Return the Base64-encoded encrypted string
		return encodeBase64String(encryptedBytes);
	}

	private static PublicKey getPublicKeyFromString(String publicKeyString) throws Exception {
		byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(keySpec);
	}

	public static String getDecryptedSek(String encryptedSek, byte[] appKey) throws Exception {
		Key aesKey = new SecretKeySpec(appKey, "AES");
		String decryptedSek = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] encryptedSekBytes = Base64.getDecoder().decode(encryptedSek);
			byte[] decryptedSekBytes = cipher.doFinal(encryptedSekBytes);
			decryptedSek = Base64.getEncoder().encodeToString(decryptedSekBytes);
			System.out.println("decryptedSek: " + decryptedSek);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedSek;
	}

}
