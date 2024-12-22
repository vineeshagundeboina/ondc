package com.fedcorp.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGED_ACCOUNTS")
public class ManagedAccounts {

	@Id
	@Column(name = "ID",unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "MANAGED_ACCOUNTS_SEQ", name = "MANAGED_ACCOUNTS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MANAGED_ACCOUNTS_SEQ")
	private Long id;

	@Column(name = "USER_ID")
	private Long userId;
	
	

	
	@Column(name = "ACCOUNTS",length = 255)
	private String accounts;
	
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public String getAccounts() {
		return accounts;
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

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setAccounts(String accounts) {
		this.accounts = accounts;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

//	public Users getUser() {
//		return user;
//	}
//
//	public void setUser(Users user) {
//		this.user = user;
//	}
	
	
	public ManagedAccounts() {
		super();
		
	}

	public ManagedAccounts(Long id, Long userId, String accounts, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.accounts = accounts;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "ManagedAccounts [id=" + id + ", userId=" + userId + ", accounts=" + accounts + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
}
