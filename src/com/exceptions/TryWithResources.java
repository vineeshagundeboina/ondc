package com.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

	public static void main(String[] args) throws FileNotFoundException,IOException{
		// TODO Auto-generated method stub
		
		File file=new File("./sample.txt");
		try(FileInputStream fis=new FileInputStream(file);
			FileReader fr=new FileReader(file)
					) {
		
		
		String str="";
		int asciiCode=0;
		
		while((asciiCode=fis.read())!=-1) {
			str=str+(char)asciiCode;
			
		}
		System.out.println(str);
		int[] arr=new int[] {1,4};
		System.out.println(arr[2]/0);
		}
		
		
		
		catch(FileNotFoundException e1) {
			e1.printStackTrace();
			
		}
		
//		catch(ArrayIndexOutOfBoundsException e2) {
//			
//			e2.printStackTrace();
//			System.err.println("please use the index within the array range");
//		}
//		catch(ArithmeticException e3) {
//			e3.printStackTrace();
//			System.err.println("please don't divide the number by zero");
//		}
		
		
		/* multiple exceptions in single catch block */
		catch(ArrayIndexOutOfBoundsException|ArithmeticException e) {
			e.printStackTrace();
			System.err.println("common ouput");
		}

	}

}
