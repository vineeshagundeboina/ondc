package com.splenta.gstreturns.service;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Convert;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

@Service
public class EncryptionDecryptionService {

	@Value("${gstpublicKey}")
	public String gstpublicKey;

	public static final String AES_TRANSFORMATION = "AES/ECB/PKCS5Padding";
	public static final String AES_ALGORITHM = "AES";
	public static final int ENC_BITS = 256;
	public static final String CHARACTER_ENCODING = "UTF-8";

	public static Cipher ENCRYPT_CIPHER;
	public static Cipher DECRYPT_CIPHER;
	public static KeyGenerator KEYGEN;

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

	public String encryptWithPublicKey(String data, String publicKeyString) throws Exception {
		// Convert the public key string to a PublicKey object
		PublicKey publicKey = getPublicKeyFromString(publicKeyString);
		// Perform the encryption
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encryptedBytes = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
		// Return the Base64-encoded encrypted string
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	public PublicKey getPublicKeyFromString(String publicKeyString) throws Exception {
		byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(keySpec);
	}

	public byte[] decodeBase64StringTOByte(String stringData) {
		byte[] result = null;
		try {
			result = java.util.Base64.getDecoder().decode(stringData.getBytes(CHARACTER_ENCODING));
		} catch (Exception e) {

		}
		return result;
	}

	public String getDecryptedRek(String data, byte[] appKey) throws Exception {
		Key aesKey = new SecretKeySpec(appKey, "AES");
		String decryptedSek = "";
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, aesKey);
			byte[] encryptedSekBytes = Base64.getDecoder().decode(data);
			byte[] decryptedSekBytes = cipher.doFinal(encryptedSekBytes);
			decryptedSek = Base64.getEncoder().encodeToString(decryptedSekBytes);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("something went wrong");
		}
		return decryptedSek;
	}

	public byte[] getRandomAppKey() {
		UUID uuid = UUID.randomUUID();

		String randomString = uuid.toString().replace("-", "");
		return randomString.substring(0, 32).getBytes(StandardCharsets.UTF_8);
	}

	public HttpHeaders getHeaders() {
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
		headers.set("auth-token", "3bb606d4d134473692b40071714b94c7");
		headers.set("ret_period", "072017");
//		headers.set("action", "RETNEWPTF");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return headers;
	}

	public String encryptEK(byte[] plainText, byte[] secret) {
		try {
			Base64.Encoder encoder = Base64.getEncoder();
			SecretKeySpec sk = new SecretKeySpec(secret, AES_ALGORITHM);
			ENCRYPT_CIPHER.init(Cipher.ENCRYPT_MODE, sk);
			return encoder.encodeToString(ENCRYPT_CIPHER.doFinal(plainText));

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String HMAC_Encrypt(byte[] data, byte[] decryptSek) throws InvalidKeyException, NoSuchAlgorithmException {

		byte[] secretKey = decryptSek;
		SecretKeySpec signingKey = new SecretKeySpec(secretKey, "HmacSHA256");
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(signingKey);
		byte[] bytes = data;
		byte[] rawHmac = mac.doFinal(bytes);

		return new String(java.util.Base64.getEncoder().encode(rawHmac));
	}

}
