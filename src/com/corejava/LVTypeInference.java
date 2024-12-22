package com.corejava;

public class LVTypeInference {

	//var h=9;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		var j;
//		j=78;
		
		var i=10;
		var s1="hello";
		
		var var=20;
		var=var+var;
		
		var even=new Even();  //used to store class instances
		
		var arr=new int[] {1,2,5,3};
		var arr1=new int[3];
		
		arr1[0]=2;
		
		arr1[1]=3;		
		System.out.println(i);
		System.out.println(s1);
		System.out.println(var);
		System.out.println(even);
		System.out.println(arr1[1]);
		
	}

}
