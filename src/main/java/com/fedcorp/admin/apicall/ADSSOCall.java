package com.fedcorp.admin.apicall;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.LogManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ADSSOCall {

	static String adurl = "";
	String output = "";
	private static final org.apache.log4j.Logger logger = LogManager.getLogger(ADSSOCall.class);

	static {
		final Properties props = new Properties();
		try {
			InputStream stream = ADSSOCall.class.getClassLoader().getResourceAsStream("application.properties");
			props.load(stream);
			adurl = System.getenv("ADSSOURL");
//			System.out.println( props.getProperty("trustStoreLocation"));
//			System.out.println( props.getProperty("trustStorePass"));
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
			System.out.println(adurl);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String CheckUser(String Name) {
//		connectToURL(adurl);
		String data = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:tem='http://tempuri.org/'>"
				+ "<soapenv:Header/>" + "<soapenv:Body>" + "<tem:AllDetails>" + "<tem:username>" + Name
				+ "</tem:username>" + "</tem:AllDetails>" + "</soapenv:Body>" + "</soapenv:Envelope>";
System.out.println("Request: "+data);
		try {
			ResponseEntity<String> response = null;
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "text/xml");

//	 		Client client = Client.create();		
//	 		WebResource webResource = client.resource(adurl);
//	 		ClientResponse res = webResource.header("Content-Type","text/xml").post(ClientResponse.class,data);
			HttpEntity<String> entity = new HttpEntity<String>(data, headers);
			RestTemplate restTemplate1 = restTemplate();		
			response = restTemplate1.exchange(adurl, HttpMethod.POST, entity, String.class);
			output = response.getBody();
			System.out.println("Response::" + output);
			logger.info("ADLOGIN~~~Response~~~" + response);
		} catch (Exception e) {
			
			e.printStackTrace();
			logger.error(e);
		}
		return output;
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
			System.out.println(connection);

		} catch (IOException ioe) {
			System.out.println("Failure processing URL: " + theURLSpec);
			ioe.printStackTrace();
		}
	}

	public RestTemplate restTemplate() {
		RestTemplateBuilder builder = new RestTemplateBuilder();
		return builder.requestFactory(() -> disableSSl()).build();
	}

	private HttpComponentsClientHttpRequestFactory disableSSl() {
		TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
			public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
				return true;
			}

		};
		SSLContext sslContext = null;
		try {
			sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		return requestFactory;
	}

}
