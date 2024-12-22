package com.splenta.gstreturns.controller;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.gstreturns.pojo.request.CancelIrnRequest;
import com.splenta.gstreturns.pojo.request.DecryptSekRequest;
import com.splenta.gstreturns.pojo.request.EwaybillByIrn;
import com.splenta.gstreturns.pojo.request.GenerateIRNRequest;
import com.splenta.gstreturns.service.CancelIrnService;
import com.splenta.gstreturns.service.EwayInvoiceService;
import com.splenta.gstreturns.service.GenerateEwaybillByIrnService;
import com.splenta.gstreturns.util.TestCancelIRN;

@RequestMapping("api/invoice")
@CrossOrigin(origins = "*")
@RestController
public class EwayInvoiceController {

	@Autowired
	private EwayInvoiceService ewayInvoiceService;
	
	@Autowired
	private GenerateEwaybillByIrnService generateEwaybillByIrnService;

	@PostMapping("/generate-irn")
	public ResponseEntity<?> generateIRN(@RequestBody GenerateIRNRequest generateIRNRequest,
			@RequestParam(required = false, value = "sek") String sek) throws Exception {
		sek = "O4J4FEwWMau20HMCX9QKTq616ZVlQeRi6IRG+bsmd/I=";

		System.out.println("\n" + sek + "\n");
		System.out.println("---> " + generateIRNRequest.getVersion());
		JSONObject V = new JSONObject(generateIRNRequest);
		System.out.println(V.toString(4));
		return ResponseEntity.ok().body(ewayInvoiceService.generateIRN(generateIRNRequest, sek));

	}

	@PostMapping("/decryptsek")
	public ResponseEntity<?> decryptSek(@RequestBody DecryptSekRequest decryptSekRequest) throws Exception {
		System.out.println("decryptSekRequest: " + decryptSekRequest.getEncryptedSek() + "   "
				+ decryptSekRequest.getOriginalAppKey());
		return ResponseEntity.ok().body(ewayInvoiceService.getDecryptedSek(decryptSekRequest.getEncryptedSek(),
				decodeBase64StringTOByte(decryptSekRequest.getOriginalAppKey())));
	}

	public final String CHARACTER_ENCODING = "UTF-8";

	byte[] decodeBase64StringTOByte(String stringData) throws Exception {
		return java.util.Base64.getDecoder().decode(stringData.getBytes(CHARACTER_ENCODING));
	}

	@Autowired
	CancelIrnService cancelIrnService;

	@Autowired
	TestCancelIRN testCancelIRN;

	@PostMapping("/cancelIRN")

//	public void cancelIRN(@RequestBody CancelIrnRequest cancelIrnRequest,
//			@RequestParam(required = false, value = "sek") String sek) {
//		sek = "OeWdMafYNa6/WeyPQJyUF6+JAxCo+7KzNAtzlYwdwF0=";
//		System.out.println("\n" + sek + "\n");
////		System.out.println("---> " + generateIRNRequest.getVersion());
//		JSONObject V = new JSONObject(cancelIrnRequest);
//		System.out.println(V.toString(4));
//		cancelIrnService.cancelIRN(cancelIrnRequest, sek);
//
//	}

	public ResponseEntity<?> cancelIRN(@RequestBody CancelIrnRequest cancelIrnRequest,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "qePzZ6V1qsu+f69htfnzPqReIOTA96ybj8i3fh3MNSI=";
		System.out.println("\n" + sek + "\n");
//		System.out.println("---> " + generateIRNRequest.getVersion());
		JSONObject V = new JSONObject(cancelIrnRequest);
		System.out.println(V.toString(4));
		return ResponseEntity.ok().body(cancelIrnService.cancelIRN(cancelIrnRequest, sek));

	}

//	@GetMapping("/GetE-InvoiceDetailsAPIbyIRN")
//	public ResponseEntity<?> GetEinvoiceDetailsApiByIRN(@RequestParam String IRN){
//		return ResponseEntity.ok().body(ewayInvoiceService.getEinvoiceDetails());
//	}

	@GetMapping("/GetE-InvoiceDetailsAPIbyIRN")
	public void GetEinvoiceDetailsApiByIRN(@RequestParam String IRN,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "1lrdNFfChU35icyB6fwRDBibX5FVsgoFTGpmSo+NEGw=";
		ewayInvoiceService.getEinvoiceDetails(sek, IRN);
	}
	
	@PostMapping("/generateEwaybillByIRN")
	public void generateEwaybillByIRN(@RequestBody EwaybillByIrn ewaybillByIrn,
			@RequestParam(required = false, value = "sek") String sek) {
		sek = "3ez5Xof8RGP99voN+GsTghu/pA1K+2dE4ABqoJjkIU8=";
		
		generateEwaybillByIrnService.ewaybillByIrn(ewaybillByIrn, sek);

	}
	
//	@PostMapping("/generateEwaybillByIRN")
//	public ResponseEntity<?> generateEwaybillByIRN(@RequestBody EwaybillByIrn ewaybillByIrn,
//			@RequestParam(required = false, value = "sek") String sek) {
//		sek = "3ez5Xof8RGP99voN+GsTghu/pA1K+2dE4ABqoJjkIU8=";
//		
//		return ResponseEntity.ok().body(ewayInvoiceService.ewaybillByIrn(ewaybillByIrn, sek));
//
//	}
	
	
	
}
