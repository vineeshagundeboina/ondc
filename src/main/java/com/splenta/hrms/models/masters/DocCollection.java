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
public class DocCollection extends BaseEntity{
	
	private String candidateName;
	private String candidateEmail;
	private String candidateMobile;
	private String candidateRole;
	@Override
	public String toString() {
		return "DocCollection [candidateName=" + candidateName + ", candidateEmail=" + candidateEmail
				+ ", candidateMobile=" + candidateMobile + ", candidateRole=" + candidateRole + "]";
	}
	
	
	

}
