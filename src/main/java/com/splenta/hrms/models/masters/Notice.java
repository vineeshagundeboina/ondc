package com.splenta.hrms.models.masters;

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
public class Notice extends BaseEntity {

	private String title;
	private String message;
	private String attachment;

}
