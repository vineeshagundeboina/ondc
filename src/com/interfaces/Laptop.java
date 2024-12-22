package com.interfaces;

public interface Laptop {
	
	public void copy();
	public void paste();
	public void cut();
	
	public void keyboard();
	
	//java 8
	default void printing() {
		
		commonCode();
		System.out.println("implement");
	}
	
	// java 8
	static void audio() {
		
		commonCode();
		System.out.println("please implement");
	}
	
	//java 9
	
	private static void commonCode() {
		System.out.println("common code");
	}

}
