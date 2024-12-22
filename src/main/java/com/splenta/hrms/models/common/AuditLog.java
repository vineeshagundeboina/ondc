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
package com.splenta.hrms.models.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.splenta.hrms.common.BaseEntity;
import com.splenta.hrms.models.auth.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AuditLog extends BaseEntity {

	
	private String tablename;

	@ManyToOne
	private User user;

	private Date deleted_at;

	private String recordid;

	@Column(columnDefinition="TEXT")
	private String data;

	@ManyToOne
	private MenuItem menu;

	
}
