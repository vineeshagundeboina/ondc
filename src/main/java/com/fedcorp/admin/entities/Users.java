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
@Table(name = "USERS")
public class Users {
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "USERS_SEQ", name = "USERS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
	private Long id;

	@Column(name = "USER_NAME" , length = 255)
	private String userName;

	@Column(name = "ENTERPRISE_ID", length = 255)
	private String enterprisesId;

	@Column(name = "PREF_NO", length = 255)
	private String prefNo;

	@Column(name = "CUST_NO", length = 255)
	private String custNo;

	@Column(name = "TRANS_LIMIT", length = 255)
	private String transLimit;

	@Column(name = "CUSTOMER_NAME", length = 255)
	private String customerName;

	@Column(name = "MOBILE", length = 255)
	private String mobile;

	@Column(name = "AUTH_TOKEN", length = 255)
	private String authToken;

	@Column(name = "ROLE", length = 255)
	private String role;

	@Column(name = "PASSWORD", length = 255)
	private String password;

	@Column(name = "OTP", length = 255)
	private String otp;

	@Column(name = "DEVICE_TYPE", length = 255)
	private String deviceType;

	@Column(name = "PUSH_TOKEN", length = 255)
	private String pushToken;

	@Column(name = "MPIN", length = 255)
	private String mpin;

	@Column(name = "APP_TOKEN", length = 255)
	private String appToken;

	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	@Column(name = "ENCRYPTED_PASSWORD", length = 255)
	private String encryptedPassword;

	@Column(name = "RESET_PASSWORD_TOKEN", length = 255)
	private String resetPasswordToken;

	@Column(name = "RESET_PASSWORD_SENT_AT")
	private Date resetPasswordSentAt;

	@Column(name = "REMEMBER_CREATED_AT")
	private Date rememberCreatedAt;

	@Column(name = "SIGN_IN_COUNT", nullable = false, precision = 38)
	private Long signInCount;

	@Column(name = "CURRENT_SIGN_IN_AT")
	private Date currentSignInAt;

	@Column(name = "LAST_SIGN_IN_AT")
	private Date lastSignInAt;

	@Column(name = "CURRENT_SIGN_IN_IP", length = 255)
	private String currentSignInIp;

	@Column(name = "LAST_SIGN_IN_IP", length = 255)
	private String lastSignInIp;

	@Column(name = "ACC_NO", length = 255)
	private String accNo;

	@Column(name = "EMAIL", length = 255)
	private String email;

	@Column(name = "WRONG_MPIN_COUNT", length = 255)
	private String wrongMpinCount;

	@Column(name = "MPIN_CHECK_STATUS", length = 255)
	private String mpinCheckStatus;

	@Column(name = "VIEW_PWD", length = 255)
	private String viewPwd;

	@Column(name = "MARK_AS_ENABLED",columnDefinition="NUMBER(1,0) DEFAULT 1")
	private Integer markAsEnabled;

	@Column(name = "PASSWORD_CHANGED_AT")
	private Date passwordChangedAt;

	@Column(name = "OTP_EXPIRED_AT")
	private Date otpExpiredAt;

	@Column(name = "LAST_ACTIVITY_AT")
	private Date lastActivityAt;

	@Column(name = "WEB_SIGN_IN_COUNT", nullable = false, precision = 38)
	private Long webSignInCount;

	@Column(name = "ACTIVATION_STATUS", length = 255)
	private String activationStatus;

	@Column(name = "AUTHORIZED_SIGNATORY",columnDefinition="NUMBER(1,0) DEFAULT '0'")
	private Integer authorizedSignatory;

	@Column(name = "FAVOURITE_ACCOUNT", length = 255)
	private String favouriteAccount;

	@Column(name = "WRONG_ACTIVATION_TOKEN_COUNT", length = 255)
	private String wrongActivationTokenCount;

	@Column(name = "WRONG_WEB_PASSWORD_COUNT", length = 20)
	private String wrongWebPasswordCount;

	
	@Column(name = "WEB_CHECK_STATUS", length = 100)
	private String webCheckStatus;
	
	@Column(name = "APP_VERSION")
	private String appVersion;

	@Column(name = "OS_VERSION")
	private String osVersion;

	@Column(name = "OS_TYPE")
	private String osType;

	@Column(name = "IS_ACCEPTED", length = 1)
	private String isAccepted;

	@Column(name = "IS_ACCEPTED_DATE")
	private Date isAcceptedDate;
	
	@Column(name = "VIEW_PWD_HASH", length = 255)
	private String viewHash;
	

	public String getViewHash() {
		return viewHash;
	}

	public void setViewHash(String viewHash) {
		this.viewHash = viewHash;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public String getEnterprisesId() {
		return enterprisesId;
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

	public String getCustomerName() {
		return customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getAuthToken() {
		return authToken;
	}

	public String getRole() {
		return role;
	}

	public String getPassword() {
		return password;
	}

	public String getOtp() {
		return otp;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public String getPushToken() {
		return pushToken;
	}

	public String getMpin() {
		return mpin;
	}

	public String getAppToken() {
		return appToken;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public Date getResetPasswordSentAt() {
		return resetPasswordSentAt;
	}

	public Date getRememberCreatedAt() {
		return rememberCreatedAt;
	}

	public Long getSignInCount() {
		return signInCount;
	}

	public Date getCurrentSignInAt() {
		return currentSignInAt;
	}

	public Date getLastSignInAt() {
		return lastSignInAt;
	}

	public String getCurrentSignInIp() {
		return currentSignInIp;
	}

	public String getLastSignInIp() {
		return lastSignInIp;
	}

	public String getAccNo() {
		return accNo;
	}

	public String getEmail() {
		return email;
	}

	public String getWrongMpinCount() {
		return wrongMpinCount;
	}

	public String getMpinCheckStatus() {
		return mpinCheckStatus;
	}

	public String getViewPwd() {
		return viewPwd;
	}

	public Integer getMarkAsEnabled() {
		return markAsEnabled;
	}

	public Date getPasswordChangedAt() {
		return passwordChangedAt;
	}

	public Date getOtpExpiredAt() {
		return otpExpiredAt;
	}

	public Date getLastActivityAt() {
		return lastActivityAt;
	}

	public Long getWebSignInCount() {
		return webSignInCount;
	}

	public String getActivationStatus() {
		return activationStatus;
	}

	public Integer getAuthorizedSignatory() {
		return authorizedSignatory;
	}

	public String getFavouriteAccount() {
		return favouriteAccount;
	}

	public String getWrongActivationTokenCount() {
		return wrongActivationTokenCount;
	}

	public String getWrongWebPasswordCount() {
		return wrongWebPasswordCount;
	}

	
	
	
	public String getWebCheckStatus() {
		return webCheckStatus;
	}

	public void setWebCheckStatus(String webCheckStatus) {
		this.webCheckStatus = webCheckStatus;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public String getOsType() {
		return osType;
	}

	public String getIsAccepted() {
		return isAccepted;
	}

	public Date getIsAcceptedDate() {
		return isAcceptedDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEnterprisesId(String enterprisesId) {
		this.enterprisesId = enterprisesId;
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

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}

	public void setMpin(String mpin) {
		this.mpin = mpin;
	}

	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public void setResetPasswordSentAt(Date resetPasswordSentAt) {
		this.resetPasswordSentAt = resetPasswordSentAt;
	}

	public void setRememberCreatedAt(Date rememberCreatedAt) {
		this.rememberCreatedAt = rememberCreatedAt;
	}

	public void setSignInCount(Long signInCount) {
		this.signInCount = signInCount;
	}

	public void setCurrentSignInAt(Date currentSignInAt) {
		this.currentSignInAt = currentSignInAt;
	}

	public void setLastSignInAt(Date lastSignInAt) {
		this.lastSignInAt = lastSignInAt;
	}

	public void setCurrentSignInIp(String currentSignInIp) {
		this.currentSignInIp = currentSignInIp;
	}

	public void setLastSignInIp(String lastSignInIp) {
		this.lastSignInIp = lastSignInIp;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setWrongMpinCount(String wrongMpinCount) {
		this.wrongMpinCount = wrongMpinCount;
	}

	public void setMpinCheckStatus(String mpinCheckStatus) {
		this.mpinCheckStatus = mpinCheckStatus;
	}

	public void setViewPwd(String viewPwd) {
		this.viewPwd = viewPwd;
	}

	public void setMarkAsEnabled(Integer markAsEnabled) {
		this.markAsEnabled = markAsEnabled;
	}

	public void setPasswordChangedAt(Date passwordChangedAt) {
		this.passwordChangedAt = passwordChangedAt;
	}

	public void setOtpExpiredAt(Date otpExpiredAt) {
		this.otpExpiredAt = otpExpiredAt;
	}

	public void setLastActivityAt(Date lastActivityAt) {
		this.lastActivityAt = lastActivityAt;
	}

	public void setWebSignInCount(Long webSignInCount) {
		this.webSignInCount = webSignInCount;
	}

	public void setActivationStatus(String activationStatus) {
		this.activationStatus = activationStatus;
	}

	public void setAuthorizedSignatory(Integer authorizedSignatory) {
		this.authorizedSignatory = authorizedSignatory;
	}

	public void setFavouriteAccount(String favouriteAccount) {
		this.favouriteAccount = favouriteAccount;
	}

	public void setWrongActivationTokenCount(String wrongActivationTokenCount) {
		this.wrongActivationTokenCount = wrongActivationTokenCount;
	}

	public void setWrongWebPasswordCount(String wrongWebPasswordCount) {
		this.wrongWebPasswordCount = wrongWebPasswordCount;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public void setIsAccepted(String isAccepted) {
		this.isAccepted = isAccepted;
	}

	public void setIsAcceptedDate(Date isAcceptedDate) {
		this.isAcceptedDate = isAcceptedDate;
	}


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(Long id, String userName, String enterprisesId, String prefNo, String custNo, String transLimit,
			String customerName, String mobile, String authToken, String role, String password, String otp,
			String deviceType, String pushToken, String mpin, String appToken, Date createdAt, Date updatedAt,
			String encryptedPassword, String resetPasswordToken, Date resetPasswordSentAt, Date rememberCreatedAt,
			Long signInCount, Date currentSignInAt, Date lastSignInAt, String currentSignInIp, String lastSignInIp,
			String accNo, String email, String wrongMpinCount, String mpinCheckStatus, String viewPwd,
			Integer markAsEnabled, Date passwordChangedAt, Date otpExpiredAt, Date lastActivityAt,
			Long webSignInCount, String activationStatus, Integer authorizedSignatory, String favouriteAccount,
			String wrongActivationTokenCount, String wrongWebPasswordCount, String webCheckStatus, String appVersion,
			String osVersion, String osType, String isAccepted, Date isAcceptedDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.enterprisesId = enterprisesId;
		this.prefNo = prefNo;
		this.custNo = custNo;
		this.transLimit = transLimit;
		this.customerName = customerName;
		this.mobile = mobile;
		this.authToken = authToken;
		this.role = role;
		this.password = password;
		this.otp = otp;
		this.deviceType = deviceType;
		this.pushToken = pushToken;
		this.mpin = mpin;
		this.appToken = appToken;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.encryptedPassword = encryptedPassword;
		this.resetPasswordToken = resetPasswordToken;
		this.resetPasswordSentAt = resetPasswordSentAt;
		this.rememberCreatedAt = rememberCreatedAt;
		this.signInCount = signInCount;
		this.currentSignInAt = currentSignInAt;
		this.lastSignInAt = lastSignInAt;
		this.currentSignInIp = currentSignInIp;
		this.lastSignInIp = lastSignInIp;
		this.accNo = accNo;
		this.email = email;
		this.wrongMpinCount = wrongMpinCount;
		this.mpinCheckStatus = mpinCheckStatus;
		this.viewPwd = viewPwd;
		this.markAsEnabled = markAsEnabled;
		this.passwordChangedAt = passwordChangedAt;
		this.otpExpiredAt = otpExpiredAt;
		this.lastActivityAt = lastActivityAt;
		this.webSignInCount = webSignInCount;
		this.activationStatus = activationStatus;
		this.authorizedSignatory = authorizedSignatory;
		this.favouriteAccount = favouriteAccount;
		this.wrongActivationTokenCount = wrongActivationTokenCount;
		this.wrongWebPasswordCount = wrongWebPasswordCount;
		this.webCheckStatus = webCheckStatus;
		this.appVersion = appVersion;
		this.osVersion = osVersion;
		this.osType = osType;
		this.isAccepted = isAccepted;
		this.isAcceptedDate = isAcceptedDate;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", enterprisesId=" + enterprisesId + ", prefNo=" + prefNo
				+ ", custNo=" + custNo + ", transLimit=" + transLimit + ", customerName=" + customerName + ", mobile="
				+ mobile + ", authToken=" + authToken + ", role=" + role + ", password=" + password + ", otp=" + otp
				+ ", deviceType=" + deviceType + ", pushToken=" + pushToken + ", mpin=" + mpin + ", appToken="
				+ appToken + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", encryptedPassword="
				+ encryptedPassword + ", resetPasswordToken=" + resetPasswordToken + ", resetPasswordSentAt="
				+ resetPasswordSentAt + ", rememberCreatedAt=" + rememberCreatedAt + ", signInCount=" + signInCount
				+ ", currentSignInAt=" + currentSignInAt + ", lastSignInAt=" + lastSignInAt + ", currentSignInIp="
				+ currentSignInIp + ", lastSignInIp=" + lastSignInIp + ", accNo=" + accNo + ", email=" + email
				+ ", wrongMpinCount=" + wrongMpinCount + ", mpinCheckStatus=" + mpinCheckStatus + ", viewPwd=" + viewPwd
				+ ", markAsEnabled=" + markAsEnabled + ", passwordChangedAt=" + passwordChangedAt + ", otpExpiredAt="
				+ otpExpiredAt + ", lastActivityAt=" + lastActivityAt + ", webSignInCount=" + webSignInCount
				+ ", activationStatus=" + activationStatus + ", authorizedSignatory=" + authorizedSignatory
				+ ", favouriteAccount=" + favouriteAccount + ", wrongActivationTokenCount=" + wrongActivationTokenCount
				+ ", wrongWebPasswordCount=" + wrongWebPasswordCount + ", webCheckStatus=" + webCheckStatus
				+ ", appVersion=" + appVersion + ", osVersion=" + osVersion + ", osType=" + osType + ", isAccepted="
				+ isAccepted + ", isAcceptedDate=" + isAcceptedDate + "]";
	}


	
	

}
