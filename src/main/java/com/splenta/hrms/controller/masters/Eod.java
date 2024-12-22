package com.splenta.hrms.controller.masters;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class Eod extends BaseEntity {

	private Date eodDate;
	@ManyToOne
	private User reportManager;
	private String employee;
	private BigDecimal totalHours;
	private BigDecimal totalLines;

}
