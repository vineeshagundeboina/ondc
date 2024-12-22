package com.splenta.hrms.service.masters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.splenta.hrms.controller.masters.Eod;
import com.splenta.hrms.controller.masters.EodLine;
import com.splenta.hrms.controller.masters.EodLineRepo;
import com.splenta.hrms.pojo.requests.PaySlipRequest;

@Service
public class PdfGenerationService {

	@Autowired
	private EodLineRepo eodLineRepo;

	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

	public byte[] generateEodReport(List<Eod> eods) throws DocumentException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter.getInstance(document, byteArrayOutputStream);

		document.open();

		for (Eod eod : eods) {
			PdfPTable table = new PdfPTable(3); // 3 columns
			table.setWidthPercentage(100); // Make sure the table occupies 100% of available width
			table.setSpacingBefore(15f); // Add spacing before the table
			table.setWidthPercentage(100);
			addTableHeader(table);
			addTableRow(table, String.valueOf(eod.getReportManager().getEmployeeName()),
					String.valueOf(eod.getEmployee()), simpleDateFormat.format((eod.getEodDate())));
			document.add(table);

			PdfPTable table1 = new PdfPTable(4); // 3 columns
			addTableHeaderLine(table1);
			table1.setWidthPercentage(100); // Make sure the table occupies 100% of available width
			// table1.setSpacingBefore(5f); // Add spacing before the table
			table1.setSpacingAfter(15f);
			table1.setWidthPercentage(100);

			List<EodLine> eodLines = eodLineRepo.findByEodId(eod.getId());
			for (EodLine eodline : eodLines) {
				addTableRowLine(table1, eodline.getTaskName(), eodline.getTaskDescription(), eodline.getTaskStatus(),
						String.valueOf(eod.getTotalHours()));
			}

			document.add(table1);

		}
		document.close();

		return byteArrayOutputStream.toByteArray();
	}

	public byte[] generatePaySlip(String month) throws DocumentException, IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		PaySlipRequest paySlipRequest = new PaySlipRequest();
		paySlipRequest.setPaySlipMonth(month);
		paySlipRequest.setEmpId("SSPL140");
		paySlipRequest.setName("Ramesh Chata");
		paySlipRequest.setUan("101603525977");
		paySlipRequest.setPan("EJSPR6770P");
		paySlipRequest.setDoj("MAY-11-2022");
		paySlipRequest.setDesignation("SOFTWARE ENGINEER");
		paySlipRequest.setNoOfDays("31");

		Document document = new Document();
		PdfWriter.getInstance(document, outputStream);
		document.open();

		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);

		// Add header row with image and header text

		// Eod firstRowData = data.get(0);
		PdfPCell imageCell = new PdfPCell(Image.getInstance("https://portal.neomaxer.com/console/assets/neologo.png"),
				true);
		imageCell.setRowspan(2);
		PdfPCell headerCell = new PdfPCell(new Phrase("PAYSLIP"));
		headerCell.setBorder(Rectangle.BOX);
		headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		headerCell.setPadding(18);

		table.addCell(imageCell);
		table.addCell(headerCell);
		document.add(table);

		PdfPTable tableline = new PdfPTable(2);
		tableline.setWidthPercentage(100);
		// tableline.getDefaultCell().setBackgroundColor(BaseColor.MAGENTA); // Example
		// background color
		tableline.getDefaultCell().setPadding(18);
		tableline.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

		// Add header row with image and header text

		// Eod firstRowData = data.get(0);

		tableline.setHorizontalAlignment(Element.ALIGN_CENTER);

		for (int i = 1; i < 2; i++) {
			PdfPCell payslipheader = new PdfPCell(new Phrase("PAYSLIP FOR THE MONTH OF"));
			PdfPCell payslipConent = new PdfPCell(new Phrase(paySlipRequest.getPaySlipMonth()));
			payslipheader.setBackgroundColor(BaseColor.LIGHT_GRAY);
			payslipConent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell nameHeader = new PdfPCell(new Phrase("NAME OF THE EMPLOYEE"));
			PdfPCell nameConent = new PdfPCell(new Phrase(paySlipRequest.getName()));
			nameHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
			nameConent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell employeeIdHeader = new PdfPCell(new Phrase("EMPLOYEE ID"));
			PdfPCell employeeIdConent = new PdfPCell(new Phrase(paySlipRequest.getEmpId()));
			employeeIdHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
			employeeIdConent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell uanHeader = new PdfPCell(new Phrase("UAN"));
			PdfPCell uanConent = new PdfPCell(new Phrase(paySlipRequest.getUan()));
			uanHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
			uanConent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell panHeader = new PdfPCell(new Phrase("PAN"));
			PdfPCell panConent = new PdfPCell(new Phrase(paySlipRequest.getPan()));
			panHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
			panConent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell dojHeader = new PdfPCell(new Phrase("DATE OF JOIN"));
			PdfPCell dojConent = new PdfPCell(new Phrase(paySlipRequest.getDoj()));
			dojHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
			dojConent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell designationHeader = new PdfPCell(new Phrase("DESIGNATION"));
			PdfPCell designationConent = new PdfPCell(new Phrase(paySlipRequest.getDesignation()));
			designationHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
			designationConent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell noOfDaysWokedHeader = new PdfPCell(new Phrase("TOTAL DAYS WORKED"));
			PdfPCell noOfDaysWokedContent = new PdfPCell(new Phrase(paySlipRequest.getNoOfDays()));
			noOfDaysWokedHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
			noOfDaysWokedContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell empty = new PdfPCell(new Phrase(" "));
			PdfPCell emptyContent = new PdfPCell(new Phrase(" "));
			// empty.setBackgroundColor(BaseColor.LIGHT_GRAY);
			// emptyContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell particular = new PdfPCell(new Phrase("PARTICULARS"));
			PdfPCell particularContent = new PdfPCell(new Phrase("AMOUNT (RS.)"));
			particular.setBackgroundColor(BaseColor.LIGHT_GRAY);
			particularContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell empty1 = new PdfPCell(new Phrase(" "));
			PdfPCell emptyContent1 = new PdfPCell(new Phrase(" "));

			PdfPCell basicHeader = new PdfPCell(new Phrase("Basic"));
			PdfPCell basicContent = new PdfPCell(new Phrase(paySlipRequest.getBasic()));
			basicHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
			basicContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell hrAllowence = new PdfPCell(new Phrase("HOUSE RENT ALLOWANCE"));
			PdfPCell hrAllowenceContent = new PdfPCell(new Phrase(paySlipRequest.getHouseRentAllowance()));
			hrAllowence.setBackgroundColor(BaseColor.LIGHT_GRAY);
			hrAllowenceContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell convAllowenceHeader = new PdfPCell(new Phrase("CONVEYANCE ALLOWANCE"));
			PdfPCell convAllowenceContent = new PdfPCell(new Phrase(paySlipRequest.getConveyanceAllowance()));
			convAllowenceHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
			convAllowenceContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell medAllowence = new PdfPCell(new Phrase("MEDICAL ALLOWANCE"));
			PdfPCell medAllowenceContent = new PdfPCell(new Phrase(paySlipRequest.getMedicalAllowance()));
			medAllowence.setBackgroundColor(BaseColor.LIGHT_GRAY);
			medAllowenceContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell leaveTravelAllowence = new PdfPCell(new Phrase("LEAVE TRAVEL ALLOWANCE"));
			PdfPCell leaveTravelAllowenceContent = new PdfPCell(new Phrase(paySlipRequest.getLeaveTravelAllowance()));
			leaveTravelAllowence.setBackgroundColor(BaseColor.LIGHT_GRAY);
			leaveTravelAllowenceContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell specialAllowence = new PdfPCell(new Phrase("SPECIAL ALLOWANCE"));
			PdfPCell specialAllowenceContent = new PdfPCell(new Phrase(paySlipRequest.getSpecialAllowance()));
			specialAllowence.setBackgroundColor(BaseColor.LIGHT_GRAY);
			specialAllowenceContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell otherAllowence = new PdfPCell(new Phrase("OTHER ALLOWANCE / NOTICE PERIOD PAY"));
			PdfPCell otherAllowenceContent = new PdfPCell(
					new Phrase(paySlipRequest.getOtherAllowanceOrnoticePeriodPay()));
			otherAllowence.setBackgroundColor(BaseColor.LIGHT_GRAY);
			otherAllowenceContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell bonusAllowence = new PdfPCell(new Phrase("BONUS"));
			PdfPCell bonusAllowenceContent = new PdfPCell(new Phrase(paySlipRequest.getBonus()));
			bonusAllowence.setBackgroundColor(BaseColor.LIGHT_GRAY);
			bonusAllowenceContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell arrAllowence = new PdfPCell(new Phrase("ARREARS"));
			PdfPCell arrAllowenceContent = new PdfPCell(new Phrase(paySlipRequest.getBonus()));
			arrAllowence.setBackgroundColor(BaseColor.LIGHT_GRAY);
			arrAllowenceContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell gross = new PdfPCell(new Phrase("GROSS SALARY"));
			PdfPCell grossContent = new PdfPCell(new Phrase(" "));
			gross.setBackgroundColor(BaseColor.LIGHT_GRAY);
			grossContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell less = new PdfPCell(new Phrase("LESS: DEDUCTIONS"));
			PdfPCell lessContent = new PdfPCell(new Phrase(" "));
			less.setBackgroundColor(BaseColor.LIGHT_GRAY);
			lessContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell profTax = new PdfPCell(new Phrase("PROFESSION TAX"));
			PdfPCell profTaxContent = new PdfPCell(new Phrase(paySlipRequest.getProfessionTax()));
			profTax.setBackgroundColor(BaseColor.LIGHT_GRAY);
			profTaxContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell pf = new PdfPCell(new Phrase("PROFESSION TAX"));
			PdfPCell pfContent = new PdfPCell(new Phrase(paySlipRequest.getProfessionTax()));
			pf.setBackgroundColor(BaseColor.LIGHT_GRAY);
			pfContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell otherDeduction = new PdfPCell(new Phrase("OTHER DECUTION - EXCESS BONUS"));
			PdfPCell otherDeductionContent = new PdfPCell(new Phrase(paySlipRequest.getOtherDecution()));
			otherDeduction.setBackgroundColor(BaseColor.LIGHT_GRAY);
			otherDeductionContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell valDeduction = new PdfPCell(new Phrase("VOLUNTARY PROVIDENT FUND CONTRIBUTION"));
			PdfPCell valDeductionContent = new PdfPCell(
					new Phrase(paySlipRequest.getVoluntaryProvidentFundContribution()));
			valDeduction.setBackgroundColor(BaseColor.LIGHT_GRAY);
			valDeductionContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell incomeTax = new PdfPCell(new Phrase("INCOME TAX"));
			PdfPCell incomeTaxContent = new PdfPCell(new Phrase(paySlipRequest.getIncomeTax()));
			incomeTax.setBackgroundColor(BaseColor.LIGHT_GRAY);
			incomeTaxContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell totalDed = new PdfPCell(new Phrase("TOTAL OF DEDUCTIONS"));
			PdfPCell totalDedContent = new PdfPCell(new Phrase(paySlipRequest.getTotalDeductions()));
			totalDed.setBackgroundColor(BaseColor.LIGHT_GRAY);
			totalDedContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell netSalary = new PdfPCell(new Phrase("NET SALARY PAID"));
			PdfPCell netSalaryContent = new PdfPCell(new Phrase(paySlipRequest.getNetSalaryPaid()));
			netSalary.setBackgroundColor(BaseColor.LIGHT_GRAY);
			netSalaryContent.setBackgroundColor(BaseColor.LIGHT_GRAY);

			PdfPCell footer = new PdfPCell(new Phrase("for Splenta Systems Private Limited\n\nAuthorised Signatory\n\n              This is computer generated document hence no seal and signature required"));
			PdfPCell footerContent = new PdfPCell(new Phrase(" "));
			footer.setBackgroundColor(BaseColor.LIGHT_GRAY);
			footerContent.setBackgroundColor(BaseColor.LIGHT_GRAY);
//			footer.setBorder(Rectangle.LEFT | Rectangle.BOTTOM); // Set borders for the left and bottom
//			footerContent.setBorder(Rectangle.BOTTOM); // Set a 
//			
			footer.setColspan(2);
			footer.setBorder(Rectangle.LEFT | Rectangle.RIGHT| Rectangle.BOTTOM ); // Remove cell borders
			footerContent.setBorder(Rectangle.RIGHT | Rectangle.LEFT| Rectangle.BOTTOM); // Remove cell borders
            
			tableline.addCell(payslipheader);
			tableline.addCell(payslipConent);
			tableline.addCell(nameHeader);
			tableline.addCell(nameConent);
			tableline.addCell(employeeIdHeader);
			tableline.addCell(employeeIdConent);
			tableline.addCell(uanHeader);
			tableline.addCell(uanConent);

			tableline.addCell(panHeader);
			tableline.addCell(panConent);
			tableline.addCell(dojHeader);
			tableline.addCell(dojConent);
			tableline.addCell(designationHeader);
			tableline.addCell(designationConent);
			tableline.addCell(noOfDaysWokedHeader);
			tableline.addCell(noOfDaysWokedContent);
			tableline.addCell(empty);
			tableline.addCell(emptyContent);

			tableline.addCell(particular);
			tableline.addCell(particularContent);

			tableline.addCell(empty1);
			tableline.addCell(emptyContent1);

			tableline.addCell(basicHeader);
			tableline.addCell(basicContent);
			tableline.addCell(hrAllowence);
			tableline.addCell(hrAllowenceContent);
			tableline.addCell(convAllowenceHeader);
			tableline.addCell(convAllowenceContent);
			tableline.addCell(medAllowence);
			tableline.addCell(medAllowenceContent);
			tableline.addCell(leaveTravelAllowence);
			tableline.addCell(leaveTravelAllowenceContent);
			tableline.addCell(specialAllowence);
			tableline.addCell(specialAllowenceContent);
			tableline.addCell(otherAllowence);
			tableline.addCell(otherAllowenceContent);
			tableline.addCell(bonusAllowence);
			tableline.addCell(bonusAllowenceContent);
			tableline.addCell(arrAllowence);
			tableline.addCell(arrAllowenceContent);
			tableline.addCell(empty1);
			tableline.addCell(emptyContent1);
			tableline.addCell(gross);
			tableline.addCell(grossContent);
			tableline.addCell(empty1);
			tableline.addCell(emptyContent1);
			tableline.addCell(less);
			tableline.addCell(lessContent);
			tableline.addCell(empty1);
			tableline.addCell(emptyContent1);

			tableline.addCell(profTax);
			tableline.addCell(profTaxContent);
			tableline.addCell(pf);
			tableline.addCell(pfContent);
			tableline.addCell(otherDeduction);
			tableline.addCell(otherDeductionContent);
			tableline.addCell(valDeduction);
			tableline.addCell(valDeductionContent);
			tableline.addCell(incomeTax);
			tableline.addCell(incomeTaxContent);
			tableline.addCell(empty1);
			tableline.addCell(emptyContent1);
			tableline.addCell(empty1);
			tableline.addCell(emptyContent1);
			tableline.addCell(totalDed);
			tableline.addCell(totalDedContent);

			tableline.addCell(empty1);
			tableline.addCell(emptyContent1);

			tableline.addCell(netSalary);
			tableline.addCell(netSalaryContent);

			tableline.addCell(empty1);
			tableline.addCell(emptyContent1);

			tableline.addCell(footer);
			tableline.addCell(footerContent);

		}
		document.add(tableline);
		document.close();

		return outputStream.toByteArray();

	}

	private void addTableHeader(PdfPTable table) {
		Stream.of("EmployeeName", "Reporting Manager", "Date").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.ORANGE);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});

//		// Add subheaders for each parameter
//        Stream.of("Task Name", "Task Description", "Task Status","Total Hours")
//              .forEach(parameter -> {
//                  PdfPCell subHeaderCell = new PdfPCell();
//                  subHeaderCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//                  subHeaderCell.setBorderWidth(2);
//                  subHeaderCell.setPhrase(new Phrase(parameter));
//                  table.addCell(subHeaderCell);
//              });
	}

	private void addTableHeaderLine(PdfPTable table) {
		Stream.of("Task Name", "Task Description", "Task Status", "Total Hours").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}

	private void addTableRow(PdfPTable table, String reportManager, String employee, String date) {
		table.addCell(employee);
		table.addCell(reportManager);
		table.addCell(date);
	}

	private void addTableRowLine(PdfPTable table, String taskName, String taskDescription, String taskStatus,
			String totalHours) {
		table.addCell(taskName);
		table.addCell(taskDescription);
		table.addCell(taskStatus);
		table.addCell(totalHours);
	}
}
