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
@Table(name = "BRANCHES")
public class Branch {
	@Id
	@Column(name = "ID",unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "BRANCHES_SEQ", name = "BRANCHES_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANCHES_SEQ")
	private Long id;

	@Column(name = "SOL_ID", length = 255)
	private String solId;
	
	@Column(name = "BRANCH_CODE", length = 255)
	private String branchCode;
	
	@Column(name = "BRANCH_NAME", length = 255)
	private String branchName;
	
	@Column(name = "REG_CD", length = 255)
	private String regCd;
	
	@Column(name = "ZONE_CODE", length = 255)
	private String zoneCode;
	
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSolId() {
		return solId;
	}

	public void setSolId(String solId) {
		this.solId = solId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getRegCd() {
		return regCd;
	}

	public void setRegCd(String regCd) {
		this.regCd = regCd;
	}

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
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

	public Branch(Long id, String solId, String branchCode, String branchName, String regCd, String zoneCode,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.solId = solId;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.regCd = regCd;
		this.zoneCode = zoneCode;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Branch [branchid=" + id + ", solId=" + solId + ", branchCode=" + branchCode + ", branchName=" + branchName
				+ ", regCd=" + regCd + ", zoneCode=" + zoneCode + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
