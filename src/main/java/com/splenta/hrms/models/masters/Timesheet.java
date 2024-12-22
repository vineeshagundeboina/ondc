package com.splenta.hrms.models.masters;

import java.util.Date;

import javax.persistence.Entity;

import com.splenta.hrms.common.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Timesheet extends BaseEntity {
	
	private String userName;
	
	private Date logintime;
	private Date logouttime;
	private Date date;
	private String loggedlocation;
	private String loggedoutlocation;
	
}
