package com.qd.library.entity;


import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String author;
	private String isbn;
	private String genre;
	private int publicationYear;
	private boolean availability;
	
	@ManyToOne
	//@JoinColumn(name="department_id")
	private Department department;
	
	
	@Override
	public boolean equals(Object o) {
		if(this==o)return true;
		if(o==null||getClass()!=o.getClass())return false;
		Book book=(Book)o;
		return Objects.equals(isbn, book.isbn);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

}
