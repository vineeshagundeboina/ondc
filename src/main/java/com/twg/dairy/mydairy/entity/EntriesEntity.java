package com.twg.dairy.mydairy.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class EntriesEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entryDate;
	
	private String description;
	
	private long usersEntityId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getUsersEntityId() {
		return usersEntityId;
	}

	public void setUsersEntityId(long usersEntityId) {
		this.usersEntityId = usersEntityId;
	}
	
	

}
