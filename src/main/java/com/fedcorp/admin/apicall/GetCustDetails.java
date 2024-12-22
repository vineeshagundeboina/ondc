package com.fedcorp.admin.apicall;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetCustDetails {
	  static String adurl = "";
	  
	  static String keys_data = "application.properties";
	  
	  static String userid = "";
	  
	  static String pwd = "";
	  
	  static String host = "";
	  
	  static String port = "";
	  
	  String output = "";
	  private static final Logger logger = LogManager.getLogger(GetCustDetails.class);
	  
	  static {
	    Properties props = new Properties();
	    try {
	      props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
	      adurl = System.getenv("GETCUSTDETLS");
	      System.out.println(adurl);
	      userid = System.getenv("UserId");
	      pwd = System.getenv("Passwd");
	      host = System.getenv("host");
	      port = System.getenv("port");
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
	  }
	public JSONObject getCustomer(String acctno) {
		
		  JSONObject json = null;
		    String data = "<GetCustomerDetailsReq><UserId>" + userid + "</UserId>" + "<Password>" + pwd + "</Password>" + 
		      "<CustomerID></CustomerID>" + "<AccountNumber>" + acctno + "</AccountNumber>" + 
		      "<MobileNumber></MobileNumber>" + "</GetCustomerDetailsReq>";
		    try {
		      setupHandler();
		      Client client = Client.create();
		      WebResource webResource = client.resource(adurl);
		      ClientResponse res = (ClientResponse)webResource.header("Content-Type", "text/xml").post(ClientResponse.class, data);
		      this.output = (String)res.getEntity(String.class);
		      json = XML.toJSONObject(this.output);
		      logger.info("ADLOGIN~~~Response~~~" + json);
		      System.out.println("GETCUSTDETLS:"+json);
		    } catch (Exception e) {
		      System.out.print(e);
		      logger.error(e);
		    } 
		    return json;
	}
	
	 private static void setupHandler() {
		    try {
		      System.setProperty("http.proxyHost", host);
		      System.setProperty("http.proxyPort", port);
		    } catch (Exception ex) {
		      System.setProperty("http.proxyHost", "");
		      System.setProperty("http.proxyPort", "");
		    } 
		  }

}
