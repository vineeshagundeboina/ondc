package com.pojoAndBeanClass;

import java.io.Serializable;

public class JavaBeanClass implements Serializable{
	
	private int id;
	private String name;
	private double marks;
	
	public JavaBeanClass() {
		
	}
	
	public JavaBeanClass(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setMarks(double marks) {
		this.marks=marks;
	}
	
	public double getMarks() {
		return marks;
	}

}
