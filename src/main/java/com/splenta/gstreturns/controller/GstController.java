package com.splenta.gstreturns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.gstreturns.pojo.gst.GSTR1ProccedFile;
import com.splenta.gstreturns.pojo.gst.GSTR1Summary;
import com.splenta.gstreturns.service.GstService;

@RequestMapping("/api/gst")
@CrossOrigin(origins = "*")
@RestController
public class GstController {

	@Autowired
	private GstService gstService;

	@GetMapping("/gstr1-return-status")
	public ResponseEntity<?> getGSTR1Summary(@RequestParam(value = "gstin") String gstin,
			@RequestParam(value = "ret_period") String ret_period, @RequestParam(value = "refid") String refid) {

		String sek = "xkZSvIWX+WBPY9VVX60mk05noqLsb/pbvLQjmH90zH0=";
		System.out.println("\n" + gstin + "\n" + ret_period + "\n" + refid);
		return ResponseEntity.ok().body(gstService.getGSTR1Summary(gstin, ret_period, refid, sek));

	}

	@PostMapping("/gstr1-procced-file")
	public ResponseEntity<?> proccedToFileGSTR1(@RequestBody GSTR1ProccedFile gSTR1ProccedFile) {

		String sek = "xkZSvIWX+WBPY9VVX60mk05noqLsb/pbvLQjmH90zH0=";
		return ResponseEntity.ok().body(gstService.proccedToFileGSTR1(gSTR1ProccedFile, sek));

	}

	@PostMapping("/gstr1-generate-summary")
	public void generateSummaryGSTR1(@RequestBody GSTR1Summary gSTR1Summary) {

		String sek = "Y432lJ4ftS5mbt5SFIQIJzHEON2f5Kw+JWUo/vP6rao=";
		gstService.generateSummaryGSTR1(gSTR1Summary, sek);

	}

}
