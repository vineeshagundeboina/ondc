package com.fedcorp.admin.entities;

public class LoginUser {
	
	private String userSession;
	private String userScale;
	private String depname;
	private String officetype;
	private String empno;
	private String displayName;
	private String userName;

	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getUserSession() {
		return userSession;
	}
	public void setUserSession(String userSession) {
		this.userSession = userSession;
	}
	public String getUserScale() {
		return userScale;
	}
	public void setUserScale(String userScale) {
		this.userScale = userScale;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public String getOfficetype() {
		return officetype;
	}
	public void setOfficetype(String officetype) {
		this.officetype = officetype;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public LoginUser(String userSession, String userScale, String depname, String officetype, String empno,
			String displayName, String userName) {
		super();
		this.userSession = userSession;
		this.userScale = userScale;
		this.depname = depname;
		this.officetype = officetype;
		this.empno = empno;
		this.displayName = displayName;
		this.userName = userName;
	}
	public LoginUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginUser [userSession=" + userSession + ", userScale=" + userScale + ", depname=" + depname
				+ ", officetype=" + officetype + ", empno=" + empno + ", displayName=" + displayName + ", userName="
				+ userName + "]";
	}
	
	
	
}
