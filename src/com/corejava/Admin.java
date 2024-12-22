package com.corejava;

public class Admin extends Developer{
	
	
	//Developer dev=new Developer();
	

	public void manage() {
		
		super.read();
		write();
		System.out.println("manage");
	}
	
	public void read() {
		System.out.println("admin read");
	}

}
