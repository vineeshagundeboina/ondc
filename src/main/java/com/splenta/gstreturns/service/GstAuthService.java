package com.splenta.gstreturns.service;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
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

import com.google.gson.Gson;
import com.splenta.gstreturns.pojo.request.GstAuthenticateRequest;
import com.splenta.gstreturns.pojo.request.GstAuthenticateRequestForToken;
import com.splenta.gstreturns.pojo.response.AuthTokenResponse;
import com.splenta.gstreturns.pojo.response.DecryptSekResponse;
import com.splenta.gstreturns.pojo.response.OtpResponse;

@Service
public class GstAuthService {

	@Value("${gstpublicKey}")
	private String gstpublicKey;

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

	public OtpResponse getOTP(GstAuthenticateRequest authenticateRequest) {

		OtpResponse otpResponse = new OtpResponse();
		try {
			// byte[] random32bit_key = getRandomAppKey();
			String random32bit_key = generateSecureKey();
			System.out.println("random32bit_key: " + random32bit_key);
			otpResponse.setOriginalAppKey((random32bit_key));
			String encodedAppKey = generateEncAppkey(decodeBase64StringTOByte(random32bit_key));
			otpResponse.setEncryptedAppKey(encodedAppKey);
			System.out.println("encodedAppKey: " + encodedAppKey);
			authenticateRequest.setApp_key(encodedAppKey);
			JSONObject encodedMessage = getJsonObjectForOTP(authenticateRequest);
			HttpHeaders headers = getHeaders();

			System.out.println("encodedMessage: " + encodedMessage);
			try {
				otpResponse.setOtpStatus("0");
				System.out.println("\n\n\npayloadData: " + encodedMessage.toString() + "\n\n\n");
				HttpEntity<String> entity = new HttpEntity<String>(encodedMessage.toString(), headers);
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<String> responses = restTemplate.exchange(
						"https://uatapi.alankitgst.com/taxpayerapi/v1.0/authenticate", HttpMethod.POST, entity,
						String.class);
				JSONObject responseInJson = new JSONObject(responses.getBody());
				System.out.println("\n\n\nresponseInJson: " + responseInJson + "\n\n\n");
				String statusCode = responseInJson.get("status_cd").toString();
				otpResponse.setOtpStatus(statusCode);

			} catch (Exception e) {
				e.printStackTrace();

			}
		} catch (Exception e) {

		}

		return otpResponse;

	}

	static byte[] decodeBase64StringTOByte(String stringData) throws Exception {
		return java.util.Base64.getDecoder().decode(stringData.getBytes(CHARACTER_ENCODING));
	}

	public AuthTokenResponse getAuthToken(GstAuthenticateRequestForToken authenticateRequest) {

		JSONObject responseInJson = new JSONObject();
		AuthTokenResponse authTokenResponse = new AuthTokenResponse();
		try {
			System.out.println("original app key:  " + authenticateRequest.getOriginalAppKey());
			System.out.println("original otp key:  " + authenticateRequest.getOtp());
			String encodedOtp = encryptEK(authenticateRequest.getOtp().getBytes(),
					decodeBase64StringTOByte(authenticateRequest.getOriginalAppKey()));
			authenticateRequest.setOtp(encodedOtp);
			JSONObject encodedMessage = getJsonObjectForToken(authenticateRequest);
			HttpHeaders headers = getHeaders();
			try {
				System.out.println("\n\n\npayloadData: " + encodedMessage.toString() + "\n\n\n");
				HttpEntity<String> entity = new HttpEntity<String>(encodedMessage.toString(), headers);
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<String> responses = restTemplate.exchange(
						"https://uatapi.alankitgst.com/taxpayerapi/v1.0/authenticate", HttpMethod.POST, entity,
						String.class);
				responseInJson = new JSONObject(responses.getBody());

				System.out.println("\n\n\nresponseInJson: " + responseInJson + "\n\n\n");
				String json_string = new Gson().toJson(responseInJson);

				JSONObject js = new JSONObject(json_string);
				System.out.println("\n\n\nresponseInJson: " + js.getJSONObject("map") + "\n\n\n");
				authTokenResponse = new Gson().fromJson(js.getJSONObject("map").toString(), AuthTokenResponse.class);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authTokenResponse;

	}

	private static String encodeBase64String(byte[] bytes) {
		return new String(java.util.Base64.getEncoder().encode(bytes));
	}

	private static String encryptEK(byte[] plainText, byte[] secret) {
		try {

			SecretKeySpec sk = new SecretKeySpec(secret, "AES");
			ENCRYPT_CIPHER.init(Cipher.ENCRYPT_MODE, sk);
			return encodeBase64String(ENCRYPT_CIPHER.doFinal(plainText));

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String generateEncAppkey(byte[] key) {
		try {
			return encrypt(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String encrypt(byte[] plaintext) throws Exception, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

		PublicKey key = readPublicKey(
				"E://SplentaProjects/backend/GST/GST_Sandbox_Latest_Public_key/GSTN_G2B_SANDBOX_UAT_public.cert.cer");
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedByte = cipher.doFinal(plaintext);
		String encodedString = new String(java.util.Base64.getEncoder().encode(encryptedByte));
		return encodedString;
	}

	private static PublicKey readPublicKey(String filename) throws Exception {
		FileInputStream fin = new FileInputStream(filename);
		CertificateFactory f = CertificateFactory.getInstance("X.509");
		X509Certificate certificate = (X509Certificate) f.generateCertificate(fin);
		PublicKey pk = certificate.getPublicKey();
		return pk;

	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		headers.set("Ocp-Apim-Subscription-Key", "ALSND1Y1V2D3u1M9R3Z7");
		headers.set("clientid", "l7xxda1af7c62c6c40449602e5a9f448f2ef");
		headers.set("client-secret", "5a35ac266ea44bc18fdeb4bed07529d5");
		headers.set("state-cd", "27");
		headers.set("ip-usr", "10.20.3.11");
		headers.set("txn", "LAPN24235325555");
		headers.set("username", "MH_NT2.2664");
		headers.set("gstin", "27AAICN6997Q3Z4");

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	private JSONObject getJsonObjectForToken(GstAuthenticateRequestForToken authenticateRequest) {

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
			jsonData.put("action", authenticateRequest.getAction());
			jsonData.put("username", authenticateRequest.getUsername());
			jsonData.put("app_key", authenticateRequest.getEncryptedAppKey());
			jsonData.put("otp", authenticateRequest.getOtp());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonData;

	}

	private JSONObject getJsonObjectForOTP(GstAuthenticateRequest authenticateRequest) {

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
			jsonData.put("action", authenticateRequest.getAction());
			jsonData.put("app_key", authenticateRequest.getApp_key());
			jsonData.put("username", authenticateRequest.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonData;

	}

	public static String encryptWithPublicKey(String data, String publicKeyString) throws Exception {
		// Convert the public key string to a PublicKey object
		PublicKey publicKey = getPublicKeyFromString(publicKeyString);
		// Perform the encryption
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
		// Return the Base64-encoded encrypted string
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	private static PublicKey getPublicKeyFromString(String publicKeyString) throws Exception {
		byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(keySpec);
	}

	private byte[] getRandomAppKey() {
		UUID uuid = UUID.randomUUID();
		String randomString = uuid.toString().replace("-", "");
		return randomString.substring(0, 32).getBytes(StandardCharsets.UTF_8);
	}

	public DecryptSekResponse getDecryptedSek(String encryptedSek, byte[] appKey) {
		Key aesKey = new SecretKeySpec(appKey, "AES");
		DecryptSekResponse decryptSekResponse = new DecryptSekResponse();
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] encryptedSekBytes = Base64.getDecoder().decode(encryptedSek);
			byte[] decryptedSekBytes = cipher.doFinal(encryptedSekBytes);
			String decryptedSek = Base64.getEncoder().encodeToString(decryptedSekBytes);
			System.out.println("decryptedSek: " + decryptedSek);
			decryptSekResponse.setDecryptedSek(decryptedSek);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptSekResponse;
	}

	static String generateSecureKey() {
		SecretKey secretKey = KEYGEN.generateKey();
		return encodeBase64String(secretKey.getEncoded());
	}

	public String initiateOtpForEvc(String gstin, String pan, String form_type) {

		JSONObject responseInJson = new JSONObject();
		String json_string = "";
		try {
			HttpHeaders headers = getHeaders();
			try {

				HttpEntity<String> entity = new HttpEntity<String>(headers);
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<String> responses = restTemplate
						.exchange("https://uatapi.alankitgst.com/taxpayerapi/v1.0/authenticate?gstin=" + gstin + "&pan="
								+ pan + "&form_type=" + form_type, HttpMethod.GET, entity, String.class);
				responseInJson = new JSONObject(responses.getBody());

				System.out.println("\n\n\nresponseInJson: " + responseInJson + "\n\n\n");
				json_string = new Gson().toJson(responseInJson);

				JSONObject js = new JSONObject(json_string);
				System.out.println("\n\n\nresponseInJson: " + js.getJSONObject("map") + "\n\n\n");

			} catch (Exception e) {
				e.printStackTrace();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json_string;

	}

//	static String generateSecureKey()  {
//		SecretKey secretKey = KEYGEN.generateKey();
//		return encodeBase64String(secretKey.getEncoded());
//	}
}
