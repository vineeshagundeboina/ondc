package com.abstractclass;

public abstract class AbstractClass implements Laptop{
	
	public void copy() {
		System.out.println("copy");
	}
	
	public void paste() {
		System.out.println("paste");
	}
	
	public abstract void cut();
	
	public abstract void keyboard();

}
