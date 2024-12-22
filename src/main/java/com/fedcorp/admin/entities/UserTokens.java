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
@Table(name = "USER_TOKENS")
public class UserTokens {
	
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 38)
	@SequenceGenerator(sequenceName = "USER_TOKENS_SEQ", name = "USER_TOKENS_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_TOKENS_SEQ")
	private Long id;

	@Column(name = "TOKEN", length = 255)
	private String token;
	
	@Column(name = "USER_ID", precision = 38)
	private Long userId;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "USER_ID")
//	private Users user;
	
	@Column(name = "TYPE", length = 255)
	private String type;
	
	@Column(name = "EXPIRED_AT")
	private Date expiredAt;
	
	@Column(name = "ACTIVE", precision = 1)
	private Boolean active;
	
	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;
	
	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

	public Long getUserId() {
		return userId;
	}

	public String getType() {
		return type;
	}

	public Date getExpiredAt() {
		return expiredAt;
	}

	public Boolean getActive() {
		return active;
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

	public void setToken(String token) {
		this.token = token;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setExpiredAt(Date expiredAt) {
		this.expiredAt = expiredAt;
	}

	public void setActive(Boolean active) {
		this.active = active;
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
	

	public UserTokens(Long id, String token, Long userId, String type, Date expiredAt, Boolean active, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.token = token;
		this.userId = userId;
		this.type = type;
		this.expiredAt = expiredAt;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UserTokens() {
		super();
	}

	
	
	
	@Override
	public String toString() {
		return "UserTokens [id=" + id + ", token=" + token + ", userId=" + userId + ", type=" + type + ", expiredAt="
				+ expiredAt + ", active=" + active + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	

}
