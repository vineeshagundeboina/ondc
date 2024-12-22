package com.splenta.hrms.controller.masters;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.splenta.hrms.common.BaseEntity;
import com.splenta.hrms.models.auth.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EodLine extends BaseEntity {

	private String taskName;
	private String taskDescription;
	private String taskStatus;
	private BigDecimal totalHours;
	@ManyToOne
	private Eod eod;

}
