package com.fedcorp.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="APPLICATION_FORMS")
public class ApplicationForms {

	

	@Id
	@Column(name = "ID",unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "APPLICATION_FORMS_SEQ", name = "APPLICATION_FORMS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICATION_FORMS_SEQ")
	private Long id;
	
	@Column(name = "DECLARATION", length = 255)
	private String declaration;
	
	@Column(name = "REF_NO", length = 255)
	private String refNo;
	
	@Column(name = "STATUS_DESC", length = 255)
	private String statusDesc;
	
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;
	
	@Column(name = "STATUS", length = 255)
	private String status;
	
	@Column(name = "CREATED_BY", length = 255)
	private String createdBy;
	
	@Column(name = "REFERENCE_ID", length = 255)
	private String referenceId;
	
	@Column(name = "FORWARDED_BY", length = 255)
	private String forwardedBy;
	
	@Column(name = "APPROVED_BY", length = 255)
	private String approvedBy;
	
	@Column(name = "FORWARDED_AT")
	private Date forwardedAt;
	
	@Column(name = "APPROVED_AT")
	private Date approvedAt;
	
	@Column(name = "REJECTED_BY", length = 255)
	private String rejectedBy;
	
	
	@Column(name = "REJECTED_AT")
	private Date rejectedAt;
	
	@Column(name = "MODIFIED_BY", length = 255)
	private String modifiedBy;
	
	@Column(name = "MODIFIED_AT")
	private Date modifiedAt;
	
	@Column(name = "RESUBMITTED_BY", length = 255)
	private String resubmittedBy;
	
	
	@Column(name = "RESUBMITTED_AT")
	private Date resubmittedAt;


	public ApplicationForms(Long id, String declaration, String refNo, String statusDesc, Date createdAt,
			Date updatedAt, String status, String createdBy, String referenceId, String forwardedBy, String approvedBy,
			Date forwardedAt, Date approvedAt, String rejectedBy, Date rejectedAt, String modifiedBy, Date modifiedAt,
			String resubmittedBy, Date resubmittedAt) {
		super();
		this.id = id;
		this.declaration = declaration;
		this.refNo = refNo;
		this.statusDesc = statusDesc;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
		this.createdBy = createdBy;
		this.referenceId = referenceId;
		this.forwardedBy = forwardedBy;
		this.approvedBy = approvedBy;
		this.forwardedAt = forwardedAt;
		this.approvedAt = approvedAt;
		this.rejectedBy = rejectedBy;
		this.rejectedAt = rejectedAt;
		this.modifiedBy = modifiedBy;
		this.modifiedAt = modifiedAt;
		this.resubmittedBy = resubmittedBy;
		this.resubmittedAt = resubmittedAt;
	}


	public ApplicationForms() {
		super();
		
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDeclaration() {
		return declaration;
	}


	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}


	public String getRefNo() {
		return refNo;
	}


	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}


	public String getStatusDesc() {
		return statusDesc;
	}


	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getReferenceId() {
		return referenceId;
	}


	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}


	public String getForwardedBy() {
		return forwardedBy;
	}


	public void setForwardedBy(String forwardedBy) {
		this.forwardedBy = forwardedBy;
	}


	public String getApprovedBy() {
		return approvedBy;
	}


	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}


	public Date getForwardedAt() {
		return forwardedAt;
	}


	public void setForwardedAt(Date forwardedAt) {
		this.forwardedAt = forwardedAt;
	}


	public Date getApprovedAt() {
		return approvedAt;
	}


	public void setApprovedAt(Date approvedAt) {
		this.approvedAt = approvedAt;
	}


	public String getRejectedBy() {
		return rejectedBy;
	}


	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}


	public Date getRejectedAt() {
		return rejectedAt;
	}


	public void setRejectedAt(Date rejectedAt) {
		this.rejectedAt = rejectedAt;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Date getModifiedAt() {
		return modifiedAt;
	}


	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}


	public String getResubmittedBy() {
		return resubmittedBy;
	}


	public void setResubmittedBy(String resubmittedBy) {
		this.resubmittedBy = resubmittedBy;
	}


	public Date getResubmittedAt() {
		return resubmittedAt;
	}


	public void setResubmittedAt(Date resubmittedAt) {
		this.resubmittedAt = resubmittedAt;
	}


	@Override
	public String toString() {
		return "ApplicationForms [id=" + id + ", declaration=" + declaration + ", refNo=" + refNo + ", statusDesc="
				+ statusDesc + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", status=" + status
				+ ", createdBy=" + createdBy + ", referenceId=" + referenceId + ", forwardedBy=" + forwardedBy
				+ ", approvedBy=" + approvedBy + ", forwardedAt=" + forwardedAt + ", approvedAt=" + approvedAt
				+ ", rejectedBy=" + rejectedBy + ", rejectedAt=" + rejectedAt + ", modifiedBy=" + modifiedBy
				+ ", modifiedAt=" + modifiedAt + ", resubmittedBy=" + resubmittedBy + ", resubmittedAt=" + resubmittedAt
				+ "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
