package com.corejava;

public class ObjectPractice {
	int i,j;
	public ObjectPractice() {
		i=10;
		j=2;
	}
	
	public ObjectPractice(int i,int j) {
		this.i=i;
		this.j=j;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObjectPractice ob1=new ObjectPractice();
		
		ObjectPractice ob2=new ObjectPractice(10,3);
		ObjectPractice ob3=new ObjectPractice(3,5);
		System.out.println(ob1.add());
		System.out.println(ob2.add());
		System.out.println(ob3.add());
		System.out.println(ob1.i);
		System.out.println(ob1.j);
		System.out.println(ob1==ob2);
		
		System.out.println(ob2==ob3);


		
	}
	
	public int add() {
		return (i+j);
	}

}
