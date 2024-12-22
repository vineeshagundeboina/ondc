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
import com.splenta.gstreturns.pojo.gst.filing.FileGstr1B2BA;
import com.splenta.gstreturns.service.GstService;

@RequestMapping("/api/gstr1-file")
@CrossOrigin(origins = "*")
@RestController
public class Gstr1FilingController {

	@Autowired
	private GstService gstService;

	@PostMapping("/filegstr1-b2b")
	public ResponseEntity<?> fileGSTR1B2B(@RequestBody FileGstr1B2B fileGstr1B2B,
			@RequestParam(required = false, value = "sek") String sek) {

		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.fileGSTR1B2B(fileGstr1B2B, sek));

	}

	@PostMapping("/filegstr1-b2ba")
	public ResponseEntity<?> fileGSTR1B2BA(@RequestBody FileGstr1B2BA fileGstr1B2BA,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.fileGSTR1B2BA(fileGstr1B2BA, sek));

	}

	@PostMapping("/filegstr1-b2cl")
	public ResponseEntity<?> fileGSTR1B2CL(@RequestBody FileGstr1B2B fileGstr1B2B,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.fileGSTR1B2CL(fileGstr1B2B, sek));

	}

	@PostMapping("/filegstr1-b2cs")
	public ResponseEntity<?> fileGSTR1B2CS(@RequestBody FileGstr1B2B fileGstr1B2B,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.fileGSTR1B2CS(fileGstr1B2B, sek));

	}

	@PostMapping("/filegstr1-b2csa")
	public ResponseEntity<?> fileGSTR1B2CSA(@RequestBody FileGstr1B2BA fileGstr1B2BA,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.fileGSTR1B2CSA(fileGstr1B2BA, sek));

	}

	@PostMapping("/filegstr1-hsn")
	public ResponseEntity<?> fileGSTR1HSN(@RequestBody FileGstr1B2B fileGstr1B2B,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "EzBU6yTc/htFkJNsIG2Wss8NOFKVjazXDQvyuChggVw=";
		System.out.println("\n" + sek + "\n");
		return ResponseEntity.ok().body(gstService.fileGSTR1HSN(fileGstr1B2B, sek));

	}
}
