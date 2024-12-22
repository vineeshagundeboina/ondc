package com.fedcorp.admin.config;


public class SearchRequest {
	
	private String ref_no;
	private	String acc_name;
	private String acc_no;
	private String mobile;
	private String status;
	public String getRef_no() {
		return ref_no;
	}
	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SearchRequest [ref_no=" + ref_no + ", acc_name=" + acc_name + ", acc_no=" + acc_no + ", mobile="
				+ mobile + ", status=" + status + "]";
	}
	public SearchRequest(String ref_no, String acc_name, String acc_no, String mobile, String status) {
		super();
		this.ref_no = ref_no;
		this.acc_name = acc_name;
		this.acc_no = acc_no;
		this.mobile = mobile;
		this.status = status;
	}
	public SearchRequest() {
		super();
		
	}
	

}
