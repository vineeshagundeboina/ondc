package com.fedcorp.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BRANCH_VERIFICATIONS")
public class BranchVerifications {
	
	@Id
	@Column(name = "ID",unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "BRANCH_VERIFICATIONS_SEQ", name = "BRANCH_VERIFICATIONS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANCH_VERIFICATIONS_SEQ")
	private Long id;

	@Column(name = "APPLICATION_FORM_ID", precision = 38)
	private Long applicationFormId;
	
	@Column(name = "MODE_OF_OPERATION", length = 255)
	private String modeOfOperation;
	
	@Column(name = "BOARD_RESOLUTION_CONFIRMED", precision = 1)
	private Boolean boardResolutionConfirmed;
	
	@Column(name = "MODE_OF_OPERATION_CONFIRMED", precision = 1)
	private Boolean modeOfOperationConfirmed;
	
	@Column(name = "USER_DETAILS_CONFIRMED", precision = 1)
	private Boolean userDetailsConfirmed;

	public Boolean getBoardResolutionConfirmed() {
		return boardResolutionConfirmed;
	}

	public Boolean getModeOfOperationConfirmed() {
		return modeOfOperationConfirmed;
	}

	public Boolean getUserDetailsConfirmed() {
		return userDetailsConfirmed;
	}

	public Long getId() {
		return id;
	}

	public Long getApplicationFormId() {
		return applicationFormId;
	}

	public String getModeOfOperation() {
		return modeOfOperation;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public void setApplicationFormId(Long applicationFormId) {
		this.applicationFormId = applicationFormId;
	}

	public void setModeOfOperation(String modeOfOperation) {
		this.modeOfOperation = modeOfOperation;
	}

	public void setBoardResolutionConfirmed(Boolean boardResolutionConfirmed) {
		this.boardResolutionConfirmed = boardResolutionConfirmed;
	}

	public void setModeOfOperationConfirmed(Boolean modeOfOperationConfirmed) {
		this.modeOfOperationConfirmed = modeOfOperationConfirmed;
	}

	public void setUserDetailsConfirmed(Boolean userDetailsConfirmed) {
		this.userDetailsConfirmed = userDetailsConfirmed;
	}

	public BranchVerifications(Long id, Long applicationFormId, String modeOfOperation,
			Boolean boardResolutionConfirmed, Boolean modeOfOperationConfirmed, Boolean userDetailsConfirmed) {
		super();
		this.id = id;
		this.applicationFormId = applicationFormId;
		this.modeOfOperation = modeOfOperation;
		this.boardResolutionConfirmed = boardResolutionConfirmed;
		this.modeOfOperationConfirmed = modeOfOperationConfirmed;
		this.userDetailsConfirmed = userDetailsConfirmed;
	}

	public BranchVerifications() {
		super();
	}

	@Override
	public String toString() {
		return "BranchVerifications [id=" + id + ", applicationFormId=" + applicationFormId + ", modeOfOperation="
				+ modeOfOperation + ", boardResolutionConfirmed=" + boardResolutionConfirmed
				+ ", modeOfOperationConfirmed=" + modeOfOperationConfirmed + ", userDetailsConfirmed="
				+ userDetailsConfirmed + "]";
	}
	
	

}
