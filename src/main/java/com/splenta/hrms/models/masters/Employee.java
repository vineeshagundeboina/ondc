package com.splenta.hrms.models.masters;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.splenta.hrms.common.BaseEntity;
import com.splenta.hrms.models.auth.RoleType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {

	private String employeeId;
	private String name;
	private String email;
	private String mobileNumber;
	
	private String password;
	private String address;
	@ManyToOne
	private Domain domain;
	
	@ManyToOne     
	private Designation designation;
	
	@ManyToOne
	private RoleType userType;
	
	private String salary;
	private String gender;
	private String image;
	private String description;
	private Date doj;
	private String type;
	private String panNumber;
	
	

}
