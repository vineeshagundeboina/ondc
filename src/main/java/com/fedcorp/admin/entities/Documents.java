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
@Table(name = "DOCUMENTS")
public class Documents {
	
	@Id
	@Column(name = "ID",unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "DOCUMENTS_SEQ", name = "DOCUMENTS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENTS_SEQ")
	private Long id;

	@Column(name = "DOCUMENT", length = 255)
	private String document;
	
	@Column(name = "APPLICATION_FORM_ID", precision = 38)
	private Long applicationFormId;
	
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;
	
	@Column(name = "DOCUMENT_TYPE", length = 255)
	private String documentType;
	
	@Column(name = "FILENET_ID", length = 255)
	private String fileNetId;

	public Long getId() {
		return id;
	}

	public String getDocument() {
		return document;
	}

	public Long getApplicationFormId() {
		return applicationFormId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public String getDocumentType() {
		return documentType;
	}

	public String getFilenetId() {
		return fileNetId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public void setApplicationFormId(Long applicationFormId) {
		this.applicationFormId = applicationFormId;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public void setFilenetId(String filenetId) {
		this.fileNetId = filenetId;
	}

	public Documents(Long id, String document, Long applicationFormId, Date createdAt, Date updatedAt,
			String documentType, String filenetId) {
		super();
		this.id = id;
		this.document = document;
		this.applicationFormId = applicationFormId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.documentType = documentType;
		this.fileNetId = filenetId;
	}

	public Documents() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
