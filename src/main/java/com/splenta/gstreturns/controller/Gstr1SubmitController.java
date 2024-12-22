package com.splenta.gstreturns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.gstreturns.pojo.gst.filing.FileGstr1B2B;
import com.splenta.gstreturns.pojo.gst.filing.FileGstr1B2BA;
import com.splenta.gstreturns.pojo.gst.submit.SubmitGSTR1;
import com.splenta.gstreturns.service.GstService;

@RequestMapping("/api/submit")
@CrossOrigin(origins = "*")
@RestController
public class Gstr1SubmitController {

	@Autowired
	private GstService gstService;

	@PostMapping("/submitgstr1")
	public void submitGSTR1(@RequestBody SubmitGSTR1 submitGSTR1,
			@RequestParam(required = false, value = "sek") String sek) {

		sek = "6uuyiDNyjxA7h1Kzngkp8yzatPUz3+pI0hh3M55yxa4=";
		System.out.println("\n" + sek + "\n");
		gstService.submitGSTR1(submitGSTR1, sek);

	}
	
	@PostMapping("/getgstr1-summary")
	public void getGSTR1Summary(@RequestParam(value = "gstin") String gstin,@RequestParam(value = "ret_period") String ret_period,@RequestParam(value = "smrytyp") String smrytyp) {

		String sek = "6uuyiDNyjxA7h1Kzngkp8yzatPUz3+pI0hh3M55yxa4=";
		System.out.println("\n" + sek + "\n");
		gstService.getGSTR1Summary(gstin,ret_period,smrytyp, sek);

	}
	

}
