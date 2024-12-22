package com.qd.library.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	
	//@OneToMany(mappedBy = "department",cascade=CascadeType.ALL)
	@OneToMany
	private List<Book> books;
	
	@Override
	public boolean equals(Object o) {
		if(this==o)return true;
		if(o==null||getClass()!=o.getClass())return false;
		Department department=(Department)o;
		return Objects.equals(name, department.name);
		
		
				
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
