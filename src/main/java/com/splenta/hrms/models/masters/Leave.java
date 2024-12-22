package com.splenta.hrms.models.masters;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.splenta.hrms.common.BaseEntity;
import com.splenta.hrms.models.auth.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Leave extends BaseEntity {

	@ManyToOne
	private User employee;
	@ManyToOne
	private User reportManager;
	private Date leaveStart;
	private Date leaveEnd;
	private String leaveType;
	private String comments;
	private String leaveStatus;
	private String totalDays;
	private String requestStatus;
	
	private String rejectMessage;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean isForward;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean isApprove;
	
	@Column(columnDefinition = "boolean default false")
	private Boolean isReject;
	
	
	@PrePersist
	public void onCreate() {
		this.requestStatus="PEN";
//		this.isApprove=false;
//		this.isForward=false;
//		this.isReject=false;
	}
	

}
