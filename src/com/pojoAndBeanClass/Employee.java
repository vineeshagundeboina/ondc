package com.pojoAndBeanClass;

public class Employee {
	
	private int id;
	public String name;
	protected double salary;
	
	public Employee(int id) {
		this.id=id;
	}
	
	public Employee() {
		System.out.println("calling default constructor");
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return id;
	}

}
