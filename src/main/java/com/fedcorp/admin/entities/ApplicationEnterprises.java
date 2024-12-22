package com.fedcorp.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "APPLICATION_ENTERPRISES")
public class ApplicationEnterprises {



	@Id
	@Column(name = "ID",unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "APPLICATION_ENTERPRISES_SEQ", name = "APPLICATION_ENTERPRISES_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICATION_ENTERPRISES_SEQ")
	private Long id;

	@Column(name = "ACC_NAME", length = 255)
	private String accName;
	
	@Column(name = "CUST_NO", length = 255)
	private String custNo;
	
	@Column(name = "ACC_NO", length = 255)
	private String accNo;
	
	@Column(name = "ADDRESS", length = 255)
	private String address;
	
	@Column(name = "PIN", length = 255)
	private String pin;

	@Column(name="APPLICATION_FORM_ID", precision = 38)
	private Long applicationFormId;
	
	@Column(name = "EMAIL", length = 255)
	private String email;
	
	@Column(name = "MOBILE", length = 255)
	private String mobile;
	
	@Column(name = "ACC_TYPE", length = 255)
	private String accType;
	
	@Column(name = "AUTH_FUND", length = 255)
	private String authFund;
	
	@Column(name = "AUTH_EXT", length = 255)
	private String authExt;
	
	@Column(name = "AUTH_BEN", length = 255)
	private String authBen;
	
	@Column(name = "PREF_CORP", length = 255)
	private String prefCorp;
	
	@Column(name = "CREATED_AT",nullable = false)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT",nullable = false)
	private Date updatedAt;
	
	@Column(name = "CONSTITUTION", length = 255)
	private String constitution;
	
	@Column(name = "BRANCH_ID", precision = 38)
	private Long branchId;
	
	@Column(name = "ACTIVE", precision = 1)
	private Boolean active;
	




	public Boolean getActive() {
		return active;
	}







	public Long getApplicationFormId() {
		return applicationFormId;
	}




	public void setApplicationFormId(Long applicationFormId) {
		this.applicationFormId = applicationFormId;
	}







	@Column(name = "DAILY_LIMIT")
	private Long dailyLimit;
	
	@Column(name = "MONTHLY_LIMIT")
	private Long monthlyLimit;
	
	@Column(name = "COOLING_PERIOD")
	private Long coolingPeriod;
	
	@Transient
	private Long days;
	
	@Transient
	private Long hours;
	
	@Transient
	private Long minutes;
	
	@Transient
	private String applicationReferenceId;
	
	@Transient
	private String declaration;
	

	

	public Long getId() {
		return id;
	}




	public String getAccName() {
		return accName;
	}




	public String getCustNo() {
		return custNo;
	}




	public String getAccNo() {
		return accNo;
	}




	public String getAddress() {
		return address;
	}




	public String getPin() {
		return pin;
	}








	public String getEmail() {
		return email;
	}




	public String getMobile() {
		return mobile;
	}




	public String getAccType() {
		return accType;
	}




	public String getAuthFund() {
		return authFund;
	}




	public String getAuthExt() {
		return authExt;
	}




	public String getAuthBen() {
		return authBen;
	}




	public String getPrefCorp() {
		return prefCorp;
	}




	public Date getCreatedAt() {
		return createdAt;
	}




	public Date getUpdatedAt() {
		return updatedAt;
	}




	public String getConstitution() {
		return constitution;
	}




	public Long getBranchId() {
		return branchId;
	}




	public Boolean isActive() {
		return active;
	}




	public Long getDailyLimit() {
		return dailyLimit;
	}




	public Long getMonthlyLimit() {
		return monthlyLimit;
	}




	public Long getCoolingPeriod() {
		return coolingPeriod;
	}




	public Long getDays() {
		return days;
	}




	public Long getHours() {
		return hours;
	}




	public Long getMinutes() {
		return minutes;
	}




	public String getApplicationReferenceId() {
		return applicationReferenceId;
	}




	public String getDeclaration() {
		return declaration;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public void setAccName(String accName) {
		this.accName = accName;
	}




	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}




	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public void setPin(String pin) {
		this.pin = pin;
	}






	public void setEmail(String email) {
		this.email = email;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public void setAccType(String accType) {
		this.accType = accType;
	}




	public void setAuthFund(String authFund) {
		this.authFund = authFund;
	}




	public void setAuthExt(String authExt) {
		this.authExt = authExt;
	}




	public void setAuthBen(String authBen) {
		this.authBen = authBen;
	}




	public void setPrefCorp(String prefCorp) {
		this.prefCorp = prefCorp;
	}




	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}




	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}




	public void setConstitution(String constitution) {
		this.constitution = constitution;
	}




	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}




	public void setActive(Boolean active) {
		this.active = active;
	}




	public void setDailyLimit(Long dailyLimit) {
		this.dailyLimit = dailyLimit;
	}




	public void setMonthlyLimit(Long monthlyLimit) {
		this.monthlyLimit = monthlyLimit;
	}




	public void setCoolingPeriod(Long coolingPeriod) {
		this.coolingPeriod = coolingPeriod;
	}




	public void setDays(Long days) {
		this.days = days;
	}




	public void setHours(Long hours) {
		this.hours = hours;
	}




	public void setMinutes(Long minutes) {
		this.minutes = minutes;
	}




	public void setApplicationReferenceId(String applicationReferenceId) {
		this.applicationReferenceId = applicationReferenceId;
	}




	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}




	@Override
	public String toString() {
		return "ApplicationEnterprises [id=" + id + ", accName=" + accName + ", custNo=" + custNo + ", accNo=" + accNo
				+ ", address=" + address + ", pin=" + pin + ", applicationFormId=" + applicationFormId + ", email="
				+ email + ", mobile=" + mobile + ", accType=" + accType + ", authFund=" + authFund + ", authExt="
				+ authExt + ", authBen=" + authBen + ", prefCorp=" + prefCorp + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", constitution=" + constitution + ", branchId=" + branchId + ", active="
				+ active + ", dailyLimit=" + dailyLimit + ", monthlyLimit=" + monthlyLimit + ", coolingPeriod="
				+ coolingPeriod + ", days=" + days + ", hours=" + hours + ", minutes=" + minutes
				+ ", applicationReferenceId=" + applicationReferenceId + ", declaration=" + declaration + "]";
	}


	
	

}
