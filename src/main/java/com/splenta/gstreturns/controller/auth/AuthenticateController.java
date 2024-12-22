package com.splenta.gstreturns.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.splenta.gstreturns.pojo.request.AuthenticateRequest;
import com.splenta.gstreturns.pojo.request.DecryptSekRequest;
import com.splenta.gstreturns.pojo.request.GstAuthenticateRequest;
import com.splenta.gstreturns.pojo.request.GstAuthenticateRequestForToken;
import com.splenta.gstreturns.service.EwayInvoiceAuthService;
import com.splenta.gstreturns.service.GstAuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthenticateController {

	@Autowired
	private EwayInvoiceAuthService ewayInvoiceAuthService;

	@Autowired
	private GstAuthService gstAuthService;

	@GetMapping("/")
	public String getIndex() {
		return "Welcome to GST Testing APIs";
	}

	@PostMapping("/invoiceauthenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest authenticateRequest) {

		return ResponseEntity.ok().body(ewayInvoiceAuthService.autheticateUser(authenticateRequest));
	}

	@PostMapping("/gst/authenticateForOTP")
	public ResponseEntity<?> authenticateForOTP(@RequestBody GstAuthenticateRequest authenticateRequest) {

		return ResponseEntity.ok().body(gstAuthService.getOTP(authenticateRequest));
	}

	@PostMapping("/gst/authenticateForToken")
	public ResponseEntity<?> authenticateForToken(@RequestBody GstAuthenticateRequestForToken authenticateRequest) {

		return ResponseEntity.ok().body(gstAuthService.getAuthToken(authenticateRequest));
	}
	
	@PostMapping("/gst/initiateOtp")
	public ResponseEntity<?> initiateOtpForEvc(@RequestParam(value = "gstin") String gstin,
			@RequestParam(value = "pan") String pan, @RequestParam(value = "form_type") String form_type) {

		return ResponseEntity.ok().body(gstAuthService.initiateOtpForEvc(gstin,pan,form_type));
	}

	@PostMapping("/gst/decryptsek")
	public ResponseEntity<?> decryptSek(@RequestBody DecryptSekRequest decryptSekRequest) throws Exception {
		System.out.println("decryptSekRequest: " + decryptSekRequest.getEncryptedSek() + "   "
				+ decryptSekRequest.getOriginalAppKey());
		return ResponseEntity.ok().body(gstAuthService.getDecryptedSek(decryptSekRequest.getEncryptedSek(),
				decodeBase64StringTOByte(decryptSekRequest.getOriginalAppKey())));
	}

	
	
	public final String CHARACTER_ENCODING = "UTF-8";

	byte[] decodeBase64StringTOByte(String stringData) throws Exception {
		return java.util.Base64.getDecoder().decode(stringData.getBytes(CHARACTER_ENCODING));
	}
}
