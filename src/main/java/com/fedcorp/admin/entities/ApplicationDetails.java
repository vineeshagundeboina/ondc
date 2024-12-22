package com.fedcorp.admin.entities;

import java.util.Date;

public interface ApplicationDetails {

	
	public Long getId() ;

	public String getDeclaration();

	public String getRefNo() ;

	public String getStatusDesc();

	public Date getApplnFormCreatedAt();

	public Date getApplnFormUpdatedAt() ;

	public String getStatus();

	public String getCreatedBy() ;

	public String getReferenceId() ;

	public String getForwardedBy() ;

	public String getApprovedBy() ;

	public Date getForwardedAt();
	
	public Date getApprovedAt() ;

	public String getRejectedBy() ;

	public Date getRejectedAt();

	public String getModifiedBy();

	public Date getModifiedAt() ;

	public String getResubmittedBy() ;

	public Date getResubmittedAt();

	public Long getApplnEnterprisesId() ;

	public String getAccName();

	public String getCustNo() ;

	public String getAccNo();

	public String getAddress() ;

	public String getPin() ;

	public Long getApplnEnterprisesFormId() ;

	public String getEmail() ;

	public String getMobile();

	public String getAccType();

	public String getAuthFund();

	public String getAuthExt() ;

	public String getAuthBen() ;
	

	public String getPrefCorp() ;

	public Date getApplnEnterprisesCreatedAt();

	public Date getApplnEnterprisesUpdatedAt();

	public String getConstitution();

	public Long getApplnEnterprisesBranchId() ;

	public Boolean getApplnEnterprisesActive() ;

	public Long getDailyLimit();

	public Long getMonthlyLimit();

	public Long getCoolingPeriod();
	
	
	
	public Long getBranchId();
	public String getSolId() ;
	public String getBranchCode() ;
	public String getBranchName();
	public String getRegCd() ;
	public String getZoneCode();
	public Date getBranchCreatedAt();
	public Date getBranchUpdatedAt();
	
	
	
	public Long getBranchVerificationId();
	public Long getApplicationFormId() ;
	public String getModeOfOperation();
	public Integer getBoardResolutionConfirmed();
	public Integer getModeOfOperationConfirmed();
	public Integer getUserDetailsConfirmed();

	
	

	
	
}
