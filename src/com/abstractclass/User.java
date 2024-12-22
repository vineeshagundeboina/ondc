package com.abstractclass;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Lenovo lenovo=new Lenovo();
		
		lenovo.copy();
		lenovo.cut();
		lenovo.paste();
		lenovo.keyboard();
		
		
		// to provide abstraction we should use interface or abstract class while creating the object.
			
		Laptop lenovo1=new Lenovo();
		lenovo1.copy();
		lenovo1.copy();
		lenovo1.cut();
		lenovo1.paste();
		lenovo1.keyboard();
		
		
		//abstraction using abstract class,so 100% abstraction is not possible.
		AbstractClass lenovo2=new Lenovo();
		lenovo2.copy();
		lenovo2.cut();
		lenovo2.paste();
		lenovo2.keyboard();
		
		

	}

}
