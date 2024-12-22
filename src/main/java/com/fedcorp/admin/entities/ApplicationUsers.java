package com.fedcorp.admin.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "APPLICATION_USERS")
public class ApplicationUsers {
	@Id
	@Column(name = "ID",unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "APPLICATION_USERS_SEQ", name = "APPLICATION_USERS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICATION_USERS_SEQ")
	private Long id;

	@Column(name = "USER_NAME", length = 255)
	private String userName;
	
	@Column(name = "APPLICATION_ENTERPRISE_ID")
	private String applicationEnterpriseId;
	
	@Column(name = "PREF_NO", length = 255)
	private String prefNo;
	
	@Column(name = "CUST_NO", length = 255)
	private String custNo;
	

	@Column(name = "ROLE", length = 255)
	private String role;
	
	@Column(name = "TRANS_LIMIT", length = 255)
	private String transLimit;
	
	@Column(name = "MOBILE", length = 255)
	private String mobile;
	
	@Column(name = "EMAIL", length = 255)
	private String email;
	
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;
	
	@Column(name = "ACC_NO", length = 255)
	private String accNo;
	
	@Column(name = "OTP", length = 255)
	private String otp;
	
	@Column(name = "OTP_EXPIRED_AT")
	private Date otpExpiredAt;
	
	@Column(name = "ACTIVE" ,precision = 1)
	private Boolean active;
	
	@Column(name = "AUTHORIZED_SIGNATORY",precision = 1)
	private Boolean authorizedSignatory;
	
	@Transient
	private String applicationUsersMobile;
	
	@Transient
	private boolean authSignatory;
	
	@Transient
	private List<String> applicationUserName;
	
	@Transient
	private List<String> applicationPrefNo;
	
	@Transient
	private List<String> applicationCustNo;
	
	@Transient
	private List<String> applicationMobileNo;
	
	@Transient
	private List<Long> applicationTransLimit;
	
	@Transient
	private List<Boolean> applicationAuthSignatory;
	
	@Transient
	private String applicationCreatedBy;
	
	@Transient
	private Long userId;
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getApplicationCreatedBy() {
		return applicationCreatedBy;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public void setApplicationCreatedBy(String applicationCreatedBy) {
		this.applicationCreatedBy = applicationCreatedBy;
	}

	public List<String> getApplicationPrefNo() {
		return applicationPrefNo;
	}

	public List<String> getApplicationCustNo() {
		return applicationCustNo;
	}

	public List<String> getApplicationMobileNo() {
		return applicationMobileNo;
	}

	public List<Long> getApplicationTransLimit() {
		return applicationTransLimit;
	}

	public List<Boolean> getApplicationAuthSignatory() {
		return applicationAuthSignatory;
	}

	public void setApplicationPrefNo(List<String> applicationPrefNo) {
		this.applicationPrefNo = applicationPrefNo;
	}

	public void setApplicationCustNo(List<String> applicationCustNo) {
		this.applicationCustNo = applicationCustNo;
	}

	public void setApplicationMobileNo(List<String> applicationMobileNo) {
		this.applicationMobileNo = applicationMobileNo;
	}

	public void setApplicationTransLimit(List<Long> applicationTransLimit) {
		this.applicationTransLimit = applicationTransLimit;
	}

	public void setApplicationAuthSignatory(List<Boolean> applicationAuthSignatory) {
		this.applicationAuthSignatory = applicationAuthSignatory;
	}

	public List<String> getApplicationUserName() {
		return applicationUserName;
	}

	public void setApplicationUserName(List<String> applicationUserName) {
		this.applicationUserName = applicationUserName;
	}

	public boolean isAuthSignatory() {
		return authSignatory;
	}

	public void setAuthSignatory(boolean authSignatory) {
		this.authSignatory = authSignatory;
	}

	public String getApplicationUsersMobile() {
		return applicationUsersMobile;
	}

	public void setApplicationUsersMobile(String applicationUsersMobile) {
		this.applicationUsersMobile = applicationUsersMobile;
	}



	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getApplicationEnterpriseId() {
		return applicationEnterpriseId;
	}

	public String getPrefNo() {
		return prefNo;
	}

	public String getCustNo() {
		return custNo;
	}

	public String getTransLimit() {
		return transLimit;
	}

	public String getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getAccNo() {
		return accNo;
	}

	public String getOtp() {
		return otp;
	}

	public Date getOtpExpiredAt() {
		return otpExpiredAt;
	}

	public Boolean getActive() {
		return active;
	}

	public Boolean getAuthorizedSignatory() {
		return authorizedSignatory;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setApplicationEnterpriseId(String applicationEnterpriseId) {
		this.applicationEnterpriseId = applicationEnterpriseId;
	}

	public void setPrefNo(String prefNo) {
		this.prefNo = prefNo;
	}

	public void setCustNo(String custNo) {
		this.custNo = custNo;
	}

	public void setTransLimit(String transLimit) {
		this.transLimit = transLimit;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public void setOtpExpiredAt(Date otpExpiredAt) {
		this.otpExpiredAt = otpExpiredAt;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setAuthorizedSignatory(Boolean authorizedSignatory) {
		this.authorizedSignatory = authorizedSignatory;
	}

	public ApplicationUsers(Long id, String userName, String applicationEnterpriseId, String prefNo, String custNo,
			String transLimit, String mobile, String email, Date createdAt, Date updatedAt, String accNo, String otp,
			Date otpExpiredAt, Boolean active, Boolean authorizedSignatory) {
		super();
		this.id = id;
		this.userName = userName;
		this.applicationEnterpriseId = applicationEnterpriseId;
		this.prefNo = prefNo;
		this.custNo = custNo;
		this.transLimit = transLimit;
		this.mobile = mobile;
		this.email = email;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.accNo = accNo;
		this.otp = otp;
		this.otpExpiredAt = otpExpiredAt;
		this.active = active;
		this.authorizedSignatory = authorizedSignatory;
	}

	public ApplicationUsers() {
		super();
	}

	@Override
	public String toString() {
		return "ApplicationUsers [id=" + id + ", userName=" + userName + ", applicationEnterpriseId="
				+ applicationEnterpriseId + ", prefNo=" + prefNo + ", custNo=" + custNo + ", transLimit=" + transLimit
				+ ", mobile=" + mobile + ", email=" + email + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", accNo=" + accNo + ", otp=" + otp + ", otpExpiredAt=" + otpExpiredAt + ", active=" + active
				+ ", authorizedSignatory=" + authorizedSignatory + "]";
	}
	
	
	
	

}
