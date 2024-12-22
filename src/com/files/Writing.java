package com.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Writing {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
//		File file=new File("./sample.txt");
//		if(file.exists())
//			file.delete();
//		file.createNewFile();
//		FileOutputStream fos=new FileOutputStream(file);
////		fos.write(72);
////		fos.write(69);
////		fos.write(70);
////		fos.write(80);
////		fos.write(80);
//		
//		String name="vineesha";
//		for(char ch:name.toCharArray()) {
//			fos.write((int)ch);
//			
//		}
//		
//		fos.flush();
//		fos.close();
//		
		
		/* using FileWriter class*/
		
		
		
//		String s="hello world";
//		FileWriter fr=new FileWriter(file);
//		//fr.write(s);
//		fr.write(s.toCharArray());
//		fr.close();
		
		
		
		/* using bufferedwriter class*/
//		String s="dfffsjhakgk";
//		BufferedWriter bw=new BufferedWriter(new FileWriter(file));
//		bw.write(s);
//		
//		bw.flush();
//		bw.close();
		
		/* modifying the  text*/
		
		
		
		File file=new File("./sample.txt");
		
		
		String existingText=new String();
		String line="";
		BufferedReader br=new BufferedReader(new FileReader(file));

		while((line=br.readLine())!=null) {
			existingText+=line+"\n";
		}
		String s="howfvf are you doing";
		BufferedWriter bw=new BufferedWriter(new FileWriter(file));
		
		
		
		
		bw.write(existingText+s);
		bw.flush();
		bw.close();
		br.close();

	}

}
