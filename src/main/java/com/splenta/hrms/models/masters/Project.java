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
public class Project extends BaseEntity {

	private String name;
	private String image;
	private String description;
	private String title;
	
	

}
