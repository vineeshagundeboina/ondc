/*
 *************************************************************************
 * The contents of this file are subject to the Splenta  License
 * Version  1.0  (the  "License")
 * The Original Code belongs to Splenta Systems PVT LTD.
 * The Initial Developer of the Original Code is Splenta Systems PVT LTD
 * All portions are Copyright (C) 2020 Splenta Systems PVT LTD
 * All Rights Reserved.
 * Contributor(s): Vikas Ramireddy.
 ************************************************************************
 */
package com.splenta.hrms.audit;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Vikas Ramireddy
 *
 */
public class AuditLogDto {

	@JsonProperty("id")
	private String audit_id;

	private String tablename;

	private Date deleted_at;

	private String recordid;

	private String data;

	private String userUserName;

	public String getAudit_id() {
		return audit_id;
	}

	public void setAudit_id(String audit_id) {
		this.audit_id = audit_id;
	}

	public Date getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Date deleted_at) {
		this.deleted_at = deleted_at;
	}

	public String getRecordid() {
		return recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUserUserName() {
		return userUserName;
	}

	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

}
