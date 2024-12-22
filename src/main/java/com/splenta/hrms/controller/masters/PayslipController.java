package com.splenta.hrms.controller.masters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.splenta.hrms.common.GenericController;
import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.models.masters.Payslip;
import com.splenta.hrms.service.masters.EodService;
import com.splenta.hrms.service.masters.PdfGenerationService;

import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/payslip")
@Tag(name = "Payslip ", description = "APIs for Payslip related operations")
public class PayslipController extends GenericController<Payslip> {

	public PayslipController(GenericRepository<Payslip> repository) {
		super(repository);

	}

	@Autowired
	private PdfGenerationService pdfGenerationService;
	
	@Autowired
	private EodService eodService;
	

	@PostMapping("/downloadpayslip")
	public ResponseEntity<byte[]> dowloadPayslip(@RequestBody Payslip payslip) throws DocumentException, IOException {
		byte[] pdfBytes = pdfGenerationService.generatePaySlip(payslip.getMonth());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDisposition(ContentDisposition.attachment().filename("table.pdf").build());

		return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	}

	@PostMapping("/sendpayslip/{userName}")
	public void sendPayslipToMail(@RequestBody Payslip payslip,
			@PathVariable("userName") String userName) throws DocumentException, IOException {
		eodService.sendPayslipThroughMail(payslip, userName);
		
//		User user = userRepo.findByMobileNumber(userName);
//		if(user==null)
//			throw new GenericException("No User found with given username");
//		
	}

//	@PostMapping("/sendPdfEmail")
//	public ResponseEntity<String> sendPdfEmail() {
//		eodService.sendMail();
//		return ResponseEntity.ok("Email sent with PDF attachment.");
//	}

}
