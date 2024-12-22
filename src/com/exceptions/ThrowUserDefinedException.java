package com.exceptions;

public class ThrowUserDefinedException {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			int a=8;
			System.out.println(a/0);
		}
		
		
//		catch (ArithmeticException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			throw new ArithmeticException("stupid fellow,don't divide with zero");
//		}
		
		catch(ArithmeticException e) {
			throw new UserDefinedException("login failed,please check the credentials");
			
		}

	}

}
