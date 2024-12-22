package com.fedcorp.admin.apicall;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.apache.log4j.LogManager;
import org.json.JSONObject;
import org.json.XML;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class APIGateGetCustDetails {
	// API URL
	static String api_URL = "";
	static String microapi_URL = "";
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
	private static final org.apache.log4j.Logger logger = LogManager.getLogger(APIGateGetCustDetails.class);

	static {
		final Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(keys_data));
			client_id1 = System.getenv("CLIENT_ID");
			client_secret1 = System.getenv("CLIENT_SECRET");
			client_id = System.getenv("CLIENT_ID");
			client_secret = System.getenv("CLIENT_SECRET");
			userid = System.getenv("UserId");
			pwd =System.getenv("Passwd");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public APIGateGetCustDetails(String path) {
		Properties prop = new Properties();
		// Properties prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(keys_data));
		} catch (IOException e) {
			e.printStackTrace();
		}

		api_URL = System.getenv("api_URL");
		microapi_URL = System.getenv("micros_api_url");
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

	public JSONObject getCustomer(String acc_no) {
		JSONObject json = null;
		setupHandler();
		System.out.println("api_URL:"+api_URL);
		connectToURL(api_URL);
		String output = "";
		String data = "<GetCustomerDetailsReq><UserId>" + userid + "</UserId>" + "<Password>" + pwd + "</Password>"
				+ "<CustomerID></CustomerID>" + "<AccountNumber>" + acc_no + "</AccountNumber>"
				+ "<MobileNumber></MobileNumber>" + "</GetCustomerDetailsReq>";
		System.out.println("Request:"+data);
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(api_URL);
			ClientResponse response = (ClientResponse) ((WebResource.Builder) ((WebResource.Builder) ((WebResource.Builder) ((WebResource.Builder) webResource
					.accept(new String[] { "application/xml" }).header("Content-Type", "application/xml"))
					.header("x-ibm-client-id", client_id)).header("x-ibm-client-secret", client_secret))
					.type("application/xml")).post(ClientResponse.class, data);
			output = (String) response.getEntity(String.class);
			json = XML.toJSONObject(output);
			System.out.println("respose:"+output);
			logger.info("APIGateGetCustDetails~~~Response~~~" + json);
		
		} catch (Exception e) {
			System.out.print(e);
			logger.error(e);
		}
		return json;
	}

	public JSONObject GetCustomer_bck(String acc_no) {
		JSONObject json = null;
		setupHandler();
		String output = "";
		String data = "{\"acctNo\":\"" + acc_no + "\"}";
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(microapi_URL);
			ClientResponse response = (ClientResponse) ((WebResource.Builder) ((WebResource.Builder) webResource
					.accept(new String[] { "application/xml" }).header("Content-Type", "application/json"))
					.type("application/json")).post(ClientResponse.class, data);
			output = (String) response.getEntity(String.class);
			json = XML.toJSONObject(output);
			logger.info("APIGateGetCustDetails~~~Response~~~" + json);
		} catch (Exception e) {
			System.out.print(e);
			logger.error(e);
		}
		return json;
	}

	private static void setupHandler() {
		Properties p = System.getProperties();
		String s = p.getProperty("java.protocol.handler.pkgs");
		if (s == null) {
			s = "weblogic.net";
		} else if (s.indexOf("weblogic.net") == -1) {
			s = String.valueOf(s) + "|weblogic.net";
		}
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
}