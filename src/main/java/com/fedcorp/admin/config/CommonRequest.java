package com.fedcorp.admin.config;

import java.util.List;



public class CommonRequest {

	private String applnformid;

	private List<String> account;
	private Long user_id;
	private String applicationFormId;
	
	
	
	
	
	public List<String> getAccount() {
		return account;
	}

	public void setAccount(List<String> account) {
		this.account = account;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getApplicationFormId() {
		return applicationFormId;
	}

	public void setApplicationFormId(String applicationFormId) {
		this.applicationFormId = applicationFormId;
	}

	public String getApplnformid() {
		return applnformid;
	}

	public void setApplnformid(String applnformid) {
		this.applnformid = applnformid;
	}

	
	
	
}
