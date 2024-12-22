package com.interfaces;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Lenovo  lenovo=new Lenovo();
		lenovo.copy();
		lenovo.paste();
		lenovo.cut();
		lenovo.keyboard();
		
		lenovo.printing();
		
		Laptop.audio();
		
		
		Hp hp=new Hp();
		hp.copy();
		hp.printing();
	}

}
