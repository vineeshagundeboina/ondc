package com.exceptions;

public class Finally {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			int a = 10;
			System.exit(0);

			
			System.out.println(a / 0);


		}
		catch(Exception e) {
			System.out.println("catch ");
			System.exit(0);

		}
		finally {
			System.out.println("finally");
		}

	}

}
