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
@Table(name = "COMMENTS")
public class Comments {
	@Id
	@Column(name = "ID",unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "COMMENTS_SEQ", name = "COMMENTS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENTS_SEQ")
	private Long id;

	@Column(name = "BODY", length = 255)
	private String body;
	
	@Column(name = "APPLICATION_FORM_ID", length = 255)
	private String applicationFormId;
	
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;
	
	@Column(name = "ADDED_BY", length = 255)
	private String addedBy;

	public Long getId() {
		return id;
	}

	public String getBody() {
		return body;
	}

	public String getApplicationFormId() {
		return applicationFormId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setApplicationFormId(String applicationFormId) {
		this.applicationFormId = applicationFormId;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Comments(Long id, String body, String applicationFormId, Date createdAt, Date updatedAt, String addedBy) {
		super();
		this.id = id;
		this.body = body;
		this.applicationFormId = applicationFormId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.addedBy = addedBy;
	}

	public Comments() {
		super();
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", body=" + body + ", applicationFormId=" + applicationFormId + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", addedBy=" + addedBy + "]";
	}
	
	
}
