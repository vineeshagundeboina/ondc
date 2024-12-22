package com.fedcorp.admin.apicall;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Utilities {

	@Autowired
	public CustomerDetailsDev dbfed;

	public JSONObject addUser(String acctnumber, String user) {
		String userstatus;
		if (user != null) {
			userstatus = user;
		} else {
			userstatus = "";
		}
		String urlcall = "";

		if (userstatus.equals("Exist") && userstatus != "") {
			JSONObject userDetails = dbfed.existCheckUser(acctnumber);
			if (userDetails != null) {
				urlcall = userDetails.toString();
			}
		} else {
			JSONObject userDetails = dbfed.checkUser(acctnumber);
			if (userDetails != null) {
				urlcall = userDetails.toString();
			}
		}

		JSONObject jsonObject = new JSONObject(urlcall);
		
			try {
				JSONObject mobileExist = new JSONObject();
				mobileExist.put("status", false);
				String code = String.valueOf(jsonObject.get("statusCode"));
				if (code.equals("00")) {
					mobileExist = new JSONObject();
					mobileExist = dbfed.checkMobile(urlcall, acctnumber);

				}
				if (mobileExist.getBoolean("status")) {
					jsonObject = new JSONObject();
					jsonObject.put("statusCode", "01");
					jsonObject.put("status",
							String.format("Mobile Number %s Already Exists", mobileExist.getString("mobile")));

				} else {
					jsonObject = new JSONObject(urlcall);
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonObject = new JSONObject(urlcall);
			}
		
		return jsonObject;
	}

}
