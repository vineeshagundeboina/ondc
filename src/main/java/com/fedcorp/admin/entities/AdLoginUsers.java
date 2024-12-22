package com.fedcorp.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADLOGIN_USERS")
public class AdLoginUsers {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "EMPLOYEE_NO")
	private String employeeNo;
	
	@Column(name = "EMP_NAME")
	private String empName;
	
	@Column(name = "FROM_DATE")
	private Date fromDate;
	
	@Column(name = "TO_DATE")
	private Date toDate;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "CREATED_AT")
	private Date createdAt;
	
	@Column(name = "UPDATED_AT")
	private Date updatedAt;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "IS_ADMIN")
	private boolean isAdmin;
	
	@Column(name = "IS_FEDSERV")
	private boolean isFedserv;

	
	
	
	
	
	
	
	public AdLoginUsers() {
		super();
		
	}

	public AdLoginUsers(Long id, String employeeNo, String empName, Date fromDate, Date toDate, String status,
			Date createdAt, Date updatedAt, String username, boolean isAdmin, boolean isFedserv) {
		super();
		this.id = id;
		this.employeeNo = employeeNo;
		this.empName = empName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.username = username;
		this.isAdmin = isAdmin;
		this.isFedserv = isFedserv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isFedserv() {
		return isFedserv;
	}

	public void setFedserv(boolean isFedserv) {
		this.isFedserv = isFedserv;
	}

	@Override
	public String toString() {
		return "AdLoginUsers [id=" + id + ", employeeNo=" + employeeNo + ", empName=" + empName + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", username=" + username + ", isAdmin=" + isAdmin + ", isFedserv=" + isFedserv + "]";
	}
	
	
	
}
