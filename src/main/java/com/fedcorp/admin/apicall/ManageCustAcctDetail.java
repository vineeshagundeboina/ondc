package com.fedcorp.admin.apicall;

import org.json.JSONArray;
import org.json.JSONObject;

public class ManageCustAcctDetail {

	boolean accountStatus, accttype, status = false;

	
	JSONObject obj, data, dataa,acctobj1;
	JSONObject custdetails,recacct;
	public JSONObject manageCheckUser(String acctno) {
		   JSONArray aactlist = new JSONArray();
	        
	        JSONObject aactlistobj = new JSONObject();
			
			System.out.println("Manage Accounts Calling");
			
	       try {
				
				APIGateGetCustDetails urlcall = new APIGateGetCustDetails("check");
				custdetails = urlcall.getCustomer(acctno);

				JSONObject GetCustomerDetailsObj = custdetails.getJSONObject("GetCustomerDetailsResp");

				System.out.println("Fedcorp:" + GetCustomerDetailsObj.toString());

				if (GetCustomerDetailsObj.get("AccountDetails") instanceof JSONArray) {
					
					JSONArray array1 = new JSONArray();
					
					array1 = GetCustomerDetailsObj.getJSONArray("AccountDetails");
					
					System.out.println("Manage Account Json:" + GetCustomerDetailsObj.toString());
									
					for (int i = 0; i < array1.length(); i++) {
						
						recacct = array1.getJSONObject(i);
						
						if (recacct.get("ERRORCODE").equals("00")) {
							
							aactlist.put(recacct.get("FORACID"));

							aactlistobj.put("Acctlist",aactlist);
						}
						
						
					}
					if(!(aactlistobj.has("Acctlist"))){
						aactlistobj.put("msg", array1.getJSONObject(0).getString("ERRORMSG"));
					}
					
				}
				else
				{
					JSONObject GetCustomerDetailsResp = new JSONObject();
					
					GetCustomerDetailsResp = custdetails.getJSONObject("GetCustomerDetailsResp").getJSONObject("AccountDetails");

					System.out.println("Manage Account Json:" + GetCustomerDetailsResp.toString());
					
					if (GetCustomerDetailsResp.get("ERRORCODE").equals("00")) {
						
						aactlist.put(GetCustomerDetailsResp.get("FORACID"));

						aactlistobj.put("Acctlist",aactlist);
					}else{
						aactlistobj.put("msg", GetCustomerDetailsResp.get("ERRORMSG"));
					}
					
				}
				
				System.out.println("Manage Account List"+aactlistobj.toString());
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
			      
			}

			
			return aactlistobj;
			
	}

}
