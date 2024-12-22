package com.splenta.gstreturns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.gstreturns.pojo.gst.filing.FileGstr1B2B;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2B;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2BA;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2CL;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2CLA;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2CS;
import com.splenta.gstreturns.pojo.gst.save.SaveGstr1B2CSA;
import com.splenta.gstreturns.service.GstService;

@RequestMapping("/api/gstr1-save")
@CrossOrigin(origins = "*")
@RestController
public class Gstr1SaveController {

	@Autowired
	private GstService gstService;

	@PostMapping("/savegstr1-b2b")
	public ResponseEntity<?> saveGSTR1B2B(@RequestBody SaveGstr1B2B saveGstr1B2B,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "fGMm8Fh6gNc4XuKAPpa+4UoIB8lQfKZM0M1ijfIwRSs=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.saveGSTR1B2B(saveGstr1B2B, sek));

	}

	@PostMapping("/savegstr1-b2ba")
	public ResponseEntity<?> saveGSTR1B2BA(@RequestBody SaveGstr1B2BA saveGstr1B2BA,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");

		return ResponseEntity.ok().body(gstService.saveGSTR1B2BA(saveGstr1B2BA, sek));
	}

	@PostMapping("/savegstr1-b2cl")
	public ResponseEntity<?> saveGSTR1B2CL(@RequestBody SaveGstr1B2CL saveGstr1B2CL,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.saveGSTR1B2CL(saveGstr1B2CL, sek));

	}

	@PostMapping("/savegstr1-b2cla")
	public ResponseEntity<?> saveGSTR1B2CLA(@RequestBody SaveGstr1B2CLA saveGstr1B2CLA,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.saveGSTR1B2CLA(saveGstr1B2CLA, sek));

	}

	@PostMapping("/savegstr1-b2cs")
	public ResponseEntity<?> saveGSTR1B2CS(@RequestBody SaveGstr1B2CS saveGstr1B2CS,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.saveGSTR1B2CS(saveGstr1B2CS, sek));

	}

	@PostMapping("/savegstr1-b2csa")
	public ResponseEntity<?> saveGSTR1B2CSA(@RequestBody SaveGstr1B2CSA saveGstr1B2CSA,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.saveGSTR1B2CSA(saveGstr1B2CSA, sek));

	}

	@PostMapping("/savegstr1-hsn")
	public void saveGSTR1HSN(@RequestBody FileGstr1B2B fileGstr1B2B,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "";
		System.out.println("\n" + sek + "\n");
		// gstService.saveGSTR1HSN(fileGstr1B2B, sek);

	}
}
