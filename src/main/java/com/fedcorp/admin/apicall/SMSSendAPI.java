package com.fedcorp.admin.apicall;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.LogManager;
import org.json.JSONException;
import org.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SMSSendAPI {
	
	
	
	// API URL
		static String api_URL = "";
		static String smsapi_url = "";
		static String UPI_HIST = "";
		static String UPI_LIVE = "";
		static String userid = "";
		static String pwd = "";
		// properties file names
		static String keys_data = "application.properties";// keys Data
		static String client_id = "";
		static String client_secret = "";
		static String client_id1 = "";
		static String client_secret1 = "";
		private static final org.apache.log4j.Logger logger = LogManager.getLogger(SMSSendAPI.class);

		static {
			final Properties props = new Properties();
			try {
				props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(keys_data));
				client_id1 = System.getenv("CLIENT_ID");
				client_secret1 = System.getenv("CLIENT_SECRET");
				client_id = System.getenv("CLIENT_ID");
				client_secret = System.getenv("CLIENT_SECRET");
				userid = System.getenv("UserId");
				pwd = System.getenv("Passwd");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public SMSSendAPI(String path) {
			System.out.println(path);

			Properties prop = new Properties();
			// Properties prop = new Properties();
			try {
				prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(keys_data));
			} catch (IOException e) {
				e.printStackTrace();
			}

			api_URL = System.getenv("api_URL");
			smsapi_url = System.getenv("smsapi_url");

			System.out.println("Response :  " + smsapi_url);

			System.out.println(System.getenv("trustStoreLocation"));
			System.out.println(System.getenv("trustStorePass"));

			System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
			System.setProperty("https.protocols", "TLSv1.2");

			// trust store
			System.setProperty("javax.net.ssl.trustStore", System.getenv("trustStoreLocation"));
			System.setProperty("javax.net.ssl.trustStorePassword", System.getenv("trustStorePass"));
			// key store
			System.setProperty("javax.net.ssl.keyStore", System.getenv("keyStoreLocation"));
			System.setProperty("javax.net.ssl.keyStorePassword", System.getenv("keyStorePass"));
			javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(new javax.net.ssl.HostnameVerifier() {
				int i = api_URL.indexOf("/");
				int k = api_URL.lastIndexOf(":");
				String ip_address = api_URL.substring(i + 2, k);

				public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
					if (hostname.equals(ip_address)) {
						return true;
					}
					return false;
				}
			});
		}

		// main method

		public JSONObject sendingSMSAPI(String mobileNumber, String message) throws JSONException {
			JSONObject json = new JSONObject();
			setupHandler();
			connectToURL(smsapi_url);

			Properties prop = new Properties();
			// Properties prop = new Properties();
			try {
				prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(keys_data));
			} catch (IOException e) {
				e.printStackTrace();
			}

			String output = "";
			String senderId = System.getenv("sms_senderId");
			String password = System.getenv("sms_password");
			String channel = System.getenv("sms_channel");
			String templateId = System.getenv("sms_templateId");
			String referenceNo = randomString(10);
			JSONObject jsonRequest = new JSONObject();
			jsonRequest.put("senderId", senderId);
			jsonRequest.put("password", password);
			jsonRequest.put("mobileNumber", mobileNumber);
			jsonRequest.put("message", message);
			jsonRequest.put("msgType", "TXN");
			jsonRequest.put("channel", channel);
			jsonRequest.put("templateId", templateId);
			jsonRequest.put("referenceNo", referenceNo);
			try {
				Client client = Client.create();
				WebResource webResource = client.resource(smsapi_url);
				logger.info("SendingSMSAPI~~~Resquest~~~" + jsonRequest);
				ClientResponse response = (ClientResponse) ((WebResource.Builder) ((WebResource.Builder) ((WebResource.Builder) ((WebResource.Builder) webResource
						.accept(new String[] { "application/json" }).header("Content-Type", "application/json"))
								.header("x-ibm-client-id", client_id)).header("x-ibm-client-secret", client_secret))
										.type("application/json")).post(ClientResponse.class, jsonRequest.toString());
				output = (String) response.getEntity(String.class);
				logger.info("SendingSMSAPI~~~Response~~~" + output);
			} catch (Exception e) {
				System.out.print(e);
				logger.error(e);
			}
			return json;
		}

		private static void setupHandler() {
			java.util.Properties p = System.getProperties();
			String s = p.getProperty("java.protocol.handler.pkgs");
			if (s == null)
				s = "weblogic.net";
			else if (s.indexOf("weblogic.net") == -1)
				s += "|weblogic.net";
			p.put("java.protocol.handler.pkgs", s);
			System.setProperties(p);
		}

		private static void connectToURL(String theURLSpec) {
			try {
				URL theURL = new URL(theURLSpec);
				URLConnection urlConnection = theURL.openConnection();
				HttpsURLConnection connection = null;
				if (!(urlConnection instanceof HttpsURLConnection)) {
					System.out.println("The URL is not using HTTP/HTTPS: " + theURLSpec);
					return;
				}
				connection = (HttpsURLConnection) urlConnection;
				connection.connect();
			} catch (IOException ioe) {
				System.out.println("Failure processing URL: " + theURLSpec);
				ioe.printStackTrace();
			}
		}

		static final String AB = "0123456789abcdefghijklmnopqrstuvwxyz";
		static SecureRandom rnd = new SecureRandom();

		String randomString(int len) {
			StringBuilder sb = new StringBuilder(len);
			for (int i = 0; i < len; i++)
				sb.append(AB.charAt(rnd.nextInt(AB.length())));
			return sb.toString();
		}

}
