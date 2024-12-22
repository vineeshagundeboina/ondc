package com.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throw {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		int a=2;
		int b=0;
		
		File file=new File("C:/resume.docx");
		FileInputStream fis=new FileInputStream(file);
		System.out.println(fis);
		
		try {
			int result=a/b;

		}
		catch(ArithmeticException ae) {
			ae.printStackTrace();
			//throw ae;
		}
		
		System.out.println("hello");

	}

}
