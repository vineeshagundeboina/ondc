package com.splenta.hrms.service.masters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.splenta.hrms.common.GenericRepository;
import com.splenta.hrms.common.GenericService;
import com.splenta.hrms.controller.masters.Eod;
import com.splenta.hrms.controller.masters.EodRepo;
import com.splenta.hrms.models.masters.DocCollection;
import com.splenta.hrms.models.masters.Employee;
import com.splenta.hrms.models.masters.Leave;
import com.splenta.hrms.models.masters.Payslip;
import com.splenta.hrms.repos.masters.EmployeeRepo;

@Service
public class EodService extends GenericService<Eod> {

	public EodService(GenericRepository<Eod> repository) {
		super(repository);

	}

	@Autowired
	private EodRepo eodRepo;

	@Value("${spring.mail.username}")
	private String sender;

	@Autowired
	private PdfGenerationService pdfGenerationService;

	@Autowired
	private SpringTemplateEngine thymeleafTemplateEngine;

	@Autowired
	JavaMailSender javaMailSender;

	private Logger logger = LoggerFactory.getLogger(EodService.class);

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private EmployeeRepo employeeRepo;

	public void sendMail() {
		try {
			Context thymeleafContext = new Context();
			Map<String, Object> templateModel = new HashMap<String, Object>();
			templateModel.put("Eod", eodRepo.findAll());
			thymeleafContext.setVariables(templateModel);

			String htmlBody = thymeleafTemplateEngine.process("Gstr.html", thymeleafContext);
			MimeMessage email = constructHtmlEmail("Verify Email", htmlBody, null, "");

			javaMailSender.send(email);
			System.out.println("***********MAIL SENT*********");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.getPdf(response);

	}

	public void updateMorning() {
		try {

			List<Employee> employees = employeeRepo.findAll();
			for (Employee employee : employees) {
				Context thymeleafContext = new Context();
				Map<String, Object> templateModel = new HashMap<String, Object>();

				templateModel.put("employee", employee);
				thymeleafContext.setVariables(templateModel);

				String htmlBody = thymeleafTemplateEngine.process("login_update.html", thymeleafContext);
				MimeMessage email = constructHtmlEmail("Morning Update", htmlBody, null, employee.getEmail());

				javaMailSender.send(email);
			}
			System.out.println("***********MAIL SENT*********");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.getPdf(response);

	}

	
	
	
	
	
	public void docCollectionNotify(DocCollection docCollection) {
		try {

			//List<Employee> employees = employeeRepo.findAll();

			Context thymeleafContext = new Context();
			Map<String, Object> templateModel = new HashMap<String, Object>();

			templateModel.put("candidate", docCollection);
			thymeleafContext.setVariables(templateModel);

			String htmlBody = thymeleafTemplateEngine.process("doccollection-request.html", thymeleafContext);
			MimeMessage email = constructHtmlEmail("Documents Request", htmlBody, null, docCollection.getCandidateEmail());

			javaMailSender.send(email);
		
			System.out.println("***********MAIL SENT*********");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.getPdf(response);

	}

	
	
	public void leaveUpdateToManager(String roleType, Leave leave) {
		try {
			Context thymeleafContext = new Context();
			Map<String, Object> templateModel = new HashMap<String, Object>();

			// List<Employee> employees = employeeRepo.findAll();
			templateModel.put("employee", leave);
			thymeleafContext.setVariables(templateModel);

			String htmlBody = thymeleafTemplateEngine.process("manager_update.html", thymeleafContext);
			MimeMessage email = constructHtmlEmail("Leave Request Update", htmlBody, null,
					leave.getReportManager().getEmail());

			javaMailSender.send(email);
			System.out.println("***********MAIL SENT*********");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.getPdf(response);

	}

	private MimeMessage constructHtmlEmail(String title, String htmlBody, Object object, String toEmail)
			throws MessagingException {
		// TODO Auto-generated method stub
		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
		helper.setSubject(title);
		helper.setText(htmlBody, true); // Use this or above line.
		helper.setTo(toEmail);
		helper.setFrom(sender);
//		try {
//			byte[] pdfBytes = pdfGenerationService.generatePdf(eodRepo.findAll());
//
//			helper.addAttachment("employeeEod_report.pdf", new ByteArrayResource(pdfBytes));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return mail;
	}

	private MimeMessage constructHtmlEmailForLeave(String string, String htmlBody, Object object, String sendMail,
			String title) throws MessagingException {
		// TODO Auto-generated method stub
		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
		helper.setSubject(title);
		helper.setText(htmlBody, true); // Use this or above line.
		// helper.setTo("chrameshiiit44@gmail.com");
		helper.setTo(sendMail);
		helper.setFrom(sender);
//		try {
//			byte[] pdfBytes = pdfGenerationService.generatePdf(eodRepo.findAll());
//
//			helper.addAttachment("employeeEod_report.pdf", new ByteArrayResource(pdfBytes));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return mail;
	}

//	public ByteArrayInputStream exportReceiptPdf(String templateName, Map<String, Object> data)
//			throws DocumentException {
//		Context context = new Context();
//
//		context.setVariables(data);
//		String htmlContent = templateEngine.process(templateName, context);
//
//		ByteArrayInputStream byteArrayInputStream = null;
//		try {
//			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//			ITextRenderer renderer = new ITextRenderer();
//			renderer.setDocumentFromString(htmlContent);
//			renderer.layout();
//			renderer.createPDF(byteArrayOutputStream, false);
//			renderer.finishPDF();
//			byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//
//		return byteArrayInputStream;
//	}

	public void sendNotifyMail(String roleType, Leave leave) {

		try {
			Context thymeleafContext = new Context();
			Map<String, Object> templateModel = new HashMap<String, Object>();
			templateModel.put("employee", leave);
			thymeleafContext.setVariables(templateModel);
			String htmlBody = "";
			MimeMessage email = null;

			if (roleType.equalsIgnoreCase("Employee")) {
				htmlBody = thymeleafTemplateEngine.process("employee_update.html", thymeleafContext);
				email = constructHtmlEmailForLeave("LeaveNotify Email", htmlBody, null, leave.getEmployee().getEmail(),
						"Leave Request Update");

			} else {
				htmlBody = thymeleafTemplateEngine.process("manager_update.html", thymeleafContext);
				email = constructHtmlEmailForLeave("LeaveNotify Email", htmlBody, null,
						leave.getReportManager().getEmail(), "Leave Request");
			}

			javaMailSender.send(email);
			System.out.println("***********MAIL SENT*********");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.getPdf(response);

	}

	public void eodNotify() {
		try {
			Context thymeleafContext = new Context();
			Map<String, Object> templateModel = new HashMap<String, Object>();
			templateModel.put("Eod", eodRepo.findAll());
			thymeleafContext.setVariables(templateModel);

			String htmlBody = thymeleafTemplateEngine.process("Gstr.html", thymeleafContext);
			MimeMessage email = constructHtmlEmailEodReport("Verify Email", htmlBody, null, "Ramesh.c@splenta.com");

			javaMailSender.send(email);
			System.out.println("***********MAIL SENT*********");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.getPdf(response);

	}

	private MimeMessage constructHtmlEmailEodReport(String string, String htmlBody, Object object, String toEmail)
			throws MessagingException {
		// TODO Auto-generated method stub
		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
		helper.setSubject("Morning Update");
		helper.setText(htmlBody, true); // Use this or above line.
		helper.setTo(toEmail);
		helper.setFrom(sender);
		try {
			byte[] pdfBytes = pdfGenerationService.generateEodReport(eodRepo.findAll());

			helper.addAttachment("employeeEod_report.pdf", new ByteArrayResource(pdfBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mail;
	}

	public void sendPayslipThroughMail(Payslip payslip, String userName) {

		Optional<Employee> employee = employeeRepo.findByMobileNumber(userName);

		try {
			Context thymeleafContext = new Context();
			Map<String, Object> templateModel = new HashMap<String, Object>();
			templateModel.put("employeeName", employee.get().getName());
			templateModel.put("payslip", payslip);

			thymeleafContext.setVariables(templateModel);

			String htmlBody = thymeleafTemplateEngine.process("payslip.html", thymeleafContext);
			MimeMessage email = constructHtmlEmailForPayslip("Verify Email", htmlBody, null, employee.get().getEmail(),
					payslip.getMonth());

			javaMailSender.send(email);
			System.out.println("***********MAIL SENT*********");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// this.getPdf(response);

	}

	private MimeMessage constructHtmlEmailForPayslip(String string, String htmlBody, Object object, String toEmail,
			String month) throws MessagingException {
		// TODO Auto-generated method stub
		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true, "utf-8");
		helper.setSubject(month+" Payslip");
		helper.setText(htmlBody, true); // Use this or above line.
		helper.setTo(toEmail);
		helper.setFrom(sender);
		try {
			byte[] pdfBytes = pdfGenerationService.generatePaySlip(month);

			helper.addAttachment("Employee_Payslip_" + month + ".pdf", new ByteArrayResource(pdfBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mail;
	}
}
