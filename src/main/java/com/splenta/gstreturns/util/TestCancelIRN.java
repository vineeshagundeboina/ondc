package com.splenta.gstreturns.util;

import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.splenta.gstreturns.pojo.request.CancelIrnRequest;

@Configuration
public class TestCancelIRN {

	@Autowired
	Util util;

	public void cancelIrn(CancelIrnRequest cancelIrnRequest) {

		Map<String, String> cancelMainObject = new LinkedHashMap<>();
		String data = "";

		cancelMainObject.put("Irn", cancelIrnRequest.getIrn());
		cancelMainObject.put("CnlRsn", cancelIrnRequest.getCnlRsn());
		cancelMainObject.put("CnlRem", cancelIrnRequest.getCnlRem());

		System.out.println("cancelMainObject    ------>      " + cancelMainObject.toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			data = mapper.writeValueAsString(cancelMainObject.toString());
			System.out.println("data " + data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String base64 = Base64.getEncoder().encodeToString(data.getBytes());
		System.out.println("base64 " + base64);

	}
}
