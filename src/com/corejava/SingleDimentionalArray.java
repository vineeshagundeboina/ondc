package com.corejava;

import java.util.Arrays;

public class SingleDimentionalArray {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// array ni define cheyadam
//		int[] i=new int[5];
//		//String[] m=new String[5];
//		i[0]=2;
//		i[3]=4;
//		System.out.println(i[2]);
//		for(int m=0;m<i.length;m++) {
//			System.out.println(i[m]);
//		}
//		int sum=i[0]+i[1]+i[2]+i[3]+i[4];
//		System.out.println(sum);
		// int j[];
//		Bank[] j;
//		long[] k;
//		
		// initialize cheyalante size ni specify cheyali,object create cheyadam valla
		// size anedi specify chestham,
		// 2nd way
//		int[] j = {2,4,45,7}; 
//		for(int i=0;i<j.length;i++) {
//			System.out.println(j[i]);
//		}

		// int[] i=new int[] {2,3,5,8};

//		int[] array=new int[5];
//		array[0]=2;
//		array[1]=5;
//		array[2]=3;
//		array[3]=9;
//		array[4]=6;
//		int sum=0;
//		for(int i=0;i<array.length;i++) {
//			sum+=array[i];
//		}
//		int avg=sum/array.length;
//		System.out.println(sum);
//		System.out.println(avg);

//		String[] arr1= {"chai","coffee"};
//		String[] arr2= {"milk","water","coke"};
//
//		String[] c=new String[arr1.length+arr2.length];
//		for(int i=0;i<arr1.length;i++) {
//			c[i]=arr1[i];
//		}
//		
//		for(int i=0;i<arr2.length;i++) {
//			c[arr1.length+i]=arr2[i];
//		}
//		for(int i=0;i<(arr1.length+arr2.length);i++) {
//			System.out.println(c[i].toString());
//		}
//		
//		System.out.println(Arrays.toString(c));
//		
//		

//		int[] a = new int[] { 1, 2, 10, 3, 5 };
//		
// 
//		int[] result=maxNumber(a);
//		
//		
//
//		System.out.println("max " + result[0]);
//		System.out.println("index " + result[1]);
//	}
//
//	public static int[] maxNumber(int[] a) {
//		
//		int max = a[0];
//
//		int index = 0;
//		for (int i = 1; i < a.length; i++) {
//			
//			if (a[i] > max) {
//				max = a[i];
//				index = i;
//
//			}
//		}
//		return new int[]{max,index};
		
		
//		String[] a=new String[] {"coffee","water","chai","diet coke"};
//		int min=a[0].length();
//		String minLengthString=null;
//		int index=0;
//		
//		for(int i=1;i<a.length;i++) {
//			if(a[i].length()<min) {
//				min=a[i].length();
//				minLengthString=a[i];
//				
//				index=i;
//			}
//		}
//		System.out.println("minLengthString : "+minLengthString);
//		System.out.println("min "+min);
//		System.out.println("index "+index);
		
		
		boolean[] arr=new boolean[] {true,false,false,true,false,true};
		boolean[] arr1=new boolean[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			System.out.println(arr[i]);
		}
		
		
	}

}
