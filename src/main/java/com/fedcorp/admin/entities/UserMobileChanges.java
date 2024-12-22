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
@Table(name = "USER_MOBILE_CHANGES")
public class UserMobileChanges {

	@Id
	@Column(name = "ID",unique = true, nullable = false)
	@SequenceGenerator(sequenceName = "USER_MOBILE_CHANGES_SEQ", name = "USER_MOBILE_CHANGES_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_MOBILE_CHANGES_SEQ")
	private Long id;

	@Column(name = "CUSTOMER_NO")
	private String customerNo;
	
	@Column(name = "OLD_MOBILE_NO")
	private String oldMobileNo;
	
	@Column(name = "NEW_MOBILE_NO")
	private String newMobileNo;
	
	
	@Column(name = "CREATED_AT")
	private Date createdAt;
	
	@Column(name = "UPDATED_AT")
	private Date updatedAt;
	
	
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	



	public Long getId() {
		return id;
	}

	public String getCustomerNo() {
		return customerNo;
	}

	public String getOldMobileNo() {
		return oldMobileNo;
	}

	public String getNewMobileNo() {
		return newMobileNo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}

	public void setOldMobileNo(String oldMobileNo) {
		this.oldMobileNo = oldMobileNo;
	}

	public void setNewMobileNo(String newMobileNo) {
		this.newMobileNo = newMobileNo;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public UserMobileChanges(Long id, String customerNo, String oldMobileNo, String newMobileNo, Date createdAt,
			Date updatedAt,String updatedBy) {
		super();
		this.id = id;
		this.customerNo = customerNo;
		this.oldMobileNo = oldMobileNo;
		this.newMobileNo = newMobileNo;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public UserMobileChanges() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserMobileChanges [id=" + id + ", customerNo=" + customerNo + ", oldMobileNo=" + oldMobileNo
				+ ", newMobileNo=" + newMobileNo + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy +"]";
	}
	
	
	

}
