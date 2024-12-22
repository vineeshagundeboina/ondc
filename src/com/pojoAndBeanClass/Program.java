package com.pojoAndBeanClass;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee p=new Employee();
		p.name="vineesha";
		p.salary=150000.90;
		p.setId(1);
		
		Employee e1=new Employee();
		
		e1.setId(2);
		e1.name="dedede";
		e1.salary=3343;
		
		Employee e2=new Employee();
	
		e2.setId(3);
		e2.name="sasdd";
		e2.salary=32344;
		
		Employee[] employees=new Employee[] {p,e1,e2};
		
		System.out.println(employees[0].name);
		
		
//		System.out.println(p.getId());
//		System.out.println(p.name);
//		System.out.println(p.salary);

	}

}
