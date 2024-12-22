package com.splenta.hrms.pojo.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PaySlipRequest {

	private String paySlipMonth;
	private String name;
	private String empId;
	private String uan;
	private String pan;
	private String doj;
	private String designation;
	private String noOfDays;

	// particulars

	private String basic;
	private String houseRentAllowance;
	private String conveyanceAllowance;
	private String medicalAllowance;
	private String leaveTravelAllowance;
	private String specialAllowance;
	private String otherAllowanceOrnoticePeriodPay;
	private String bonus;
	private String arrears;

	// gross salary

	private String professionTax;
	private String providentFund;
	private String otherDecution;
	private String voluntaryProvidentFundContribution;
	private String incomeTax;
	private String totalDeductions;
	private String netSalaryPaid;

}
