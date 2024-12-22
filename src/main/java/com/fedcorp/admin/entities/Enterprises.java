package com.fedcorp.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "ENTERPRISES")
public class Enterprises {
	
	@Id
	@Column(name = "ID",unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "ENTERPRISES_SEQ", name = "ENTERPRISES_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTERPRISES_SEQ")
	private Long id;
	
	@Column(name = "ACC_NAME", length = 255)
	private String accName;
	
	@Column(name = "BRANCH", length = 255)
	private String branch;
	
	@Column(name = "ACC_TYPE", length = 255)
	private String accType;
	
	@Column(name = "MOBILE", length = 255)
	private String mobile;
	
	@Column(name = "AUTH_FUND", length = 255)
	private String authFund;
	
	@Column(name = "AUTH_BEN", length = 255)
	private String authBen;
	
	@Column(name = "AUTH_EXT", length = 255)
	private String authExt;
	
	@Column(name = "PREF_CORP", length = 255)
	private String prefCorp;
	
	@Column(name = "ACC_NO", length = 255)
	private String accNo;
	
	@Column(name = "CUST_NO", length = 255)
	private String custNo;
	
	@Column(name = "ADDRESS", length = 255)
	private String address;
	
	@Column(name = "PIN", length = 255)
	private String pin;
	
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;
	
	@Column(name = "CONSTITUTION", length = 255)
	private String constitution;
	
	@Column(name = "ACTIVE", precision = 1)
	private Boolean active;
	
	@Column(name = "APPLICATION_FORM_ID", precision = 38)
	private Long applicationFormId;
	
	@Column(name = "COOLING_PERIOD", precision = 38)
	private Long coolingPeriod;

	public Long getId() {
		return id;
	}

	public String getAccName() {
		return accName;
	}

	public String getBranch() {
		return branch;
	}

	public String getAccType() {
		return accType;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAuthFund() {
		return authFund;
	}

	public String getAuthBen() {
		return authBen;
	}

	public String getAuthExt() {
		return authExt;
	}

	public String getPrefCorp() {
		return prefCorp;
	}

	public String getAccNo() {
		return accNo;
	}

	public String getCustNo() {
		return custNo;
	}

	public String getAddress() {
		return address;
	}

	public String getPin() {
		return pin;
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

	public Boolean getActive() {
		return active;
	}

	public Long getApplicationFormId() {
		return applicationFormId;
	}

	public Long getCoolingPeriod() {
		return coolingPeriod;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAuthFund(String authFund) {
		this.authFund = authFund;
	}

	public void setAuthBen(String authBen) {
		this.authBen = authBen;
	}

	public void setAuthExt(String authExt) {
		this.authExt = authExt;
	}

	public void setPrefCorp(String prefCorp) {
		this.prefCorp = prefCorp;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPin(String pin) {
		this.pin = pin;
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

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setApplicationFormId(Long applicationFormId) {
		this.applicationFormId = applicationFormId;
	}

	public void setCoolingPeriod(Long coolingPeriod) {
		this.coolingPeriod = coolingPeriod;
	}

	public Enterprises(Long id, String accName, String branch, String accType, String mobile, String authFund,
			String authBen, String authExt, String prefCorp, String accNo, String custNo, String address, String pin,
			Date createdAt, Date updatedAt, String constitution, Boolean active, Long applicationFormId,
			Long coolingPeriod) {
		super();
		this.id = id;
		this.accName = accName;
		this.branch = branch;
		this.accType = accType;
		this.mobile = mobile;
		this.authFund = authFund;
		this.authBen = authBen;
		this.authExt = authExt;
		this.prefCorp = prefCorp;
		this.accNo = accNo;
		this.custNo = custNo;
		this.address = address;
		this.pin = pin;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.constitution = constitution;
		this.active = active;
		this.applicationFormId = applicationFormId;
		this.coolingPeriod = coolingPeriod;
	}

	public Enterprises() {
		super();
	}

	@Override
	public String toString() {
		return "Enterprises [id=" + id + ", accName=" + accName + ", branch=" + branch + ", accType=" + accType
				+ ", mobile=" + mobile + ", authFund=" + authFund + ", authBen=" + authBen + ", authExt=" + authExt
				+ ", prefCorp=" + prefCorp + ", accNo=" + accNo + ", custNo=" + custNo + ", address=" + address
				+ ", pin=" + pin + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", constitution="
				+ constitution + ", active=" + active + ", applicationFormId=" + applicationFormId + ", coolingPeriod="
				+ coolingPeriod + "]";
	}
	
	


}
