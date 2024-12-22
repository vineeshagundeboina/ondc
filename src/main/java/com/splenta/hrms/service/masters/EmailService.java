package com.splenta.hrms.service.masters;
//package com.splenta.neoledger.eod.email;
//
//import java.util.List;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import com.splenta.neoledger.controller.eod.Eod;
//
//@Service
//public class EmailService {
//
//	@Autowired
//	private JavaMailSender mailSender;
//
//	@Autowired
//	private PdfGenerationService pdfGenerationService;
//
//	public void sendEmailWithAttachment(List<Eod> eods, String recipientEmail) {
//		MimeMessage message = mailSender.createMimeMessage();
//		try {
//			MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//			helper.setTo(recipientEmail);
//			helper.setSubject("Employee Details Report");
//
//			byte[] pdfBytes = pdfGenerationService.generatePdf(eods);
//
//			helper.addAttachment("employee_report.pdf", new ByteArrayResource(pdfBytes));
//
//			// You can also add the email content here if needed.
//
//			mailSender.send(message);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
