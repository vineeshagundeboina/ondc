package com.corejava;

public class For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=0;i<10;i+=2) {
//			System.out.println(i);
//		}
		
//		for(int i=1;i<10;i*=2) {
//			System.out.println(i);
//		}
		
//		for(int i=0;;) {
//			System.out.println(i);
//		}
		
		for(int i=0;;) {
			if(i<10) {
				System.out.println(i);
				i++;
			}
			else
				break;
		}

	}

}
