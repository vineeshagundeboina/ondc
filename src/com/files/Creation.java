package com.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Creation {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		//*absolute path*/
		
//		File file=new File("C:\\Users\\Vineesha\\Music\\Files\\resume.txt");
//		if(file.exists())
//			System.out.println(file.delete());
//		System.out.println(file.createNewFile());
//		
//		System.out.println(file.isHidden());
//		System.out.println(file.canWrite());
//		
//		System.out.println(file.setWritable(true));
		//System.out.println(file.delete());
		
		//System.out.println(file.createNewFile());
		
	/* relative path */
		 
		
//	File file =new File("./resume.txt");
//	if(file.exists())
//		file.delete();
//	System.out.println(file.createNewFile());

		
	/* folder creation inside the project */
		//File file=new File("./Resources");
		//System.out.println(file.mkdir());
//		if(file.exists())
//			file.delete();
//		System.out.println(file.exists());
		
		
		
	/* mkdirs*/
		
//		File file = new File("./Resources/temp");
//		System.out.println(file.mkdirs());
		
		/* all the files in a given directory */
		
		
		//File file=new File("C:\\Users\\Vineesha\\ONDC\\Assessment");
		//System.out.println(Arrays.toString(file.list()));
		
		//System.out.println(Arrays.toString(file.listFiles()));
		
//		File file=new File("C:\\Users\\Vineesha\\ONDC\\Assessment\\resume.txt");
//		System.out.println(file.getName());
//		System.out.println(file.getAbsolutePath());
//		System.out.println(file.getParent());
//		File f2=new File(file.getParent()+"/resume2.docx");
//		System.out.println(f2.createNewFile());
//		System.out.println(f2.lastModified());
//		System.out.println(new Date(f2.lastModified()));
//		
//		System.out.println(f2.isDirectory());
//		
//		System.out.println(f2.isFile());
		
		
		
		/*  2nd video*/
		String text=new String();
		File file = new File("./sample.txt");
		if(!file.exists())
			file.createNewFile();
		
		
		// reading the contents from the text using fileinputstream class
		
//		FileInputStream fis= new FileInputStream(file);
//		int assciiCode;
//		
//		while((assciiCode=(fis.read()))!=-1) {
//			System.out.print((char)assciiCode);
//			text+=String.valueOf((char)assciiCode);
//
//		}
//		fis.close();
//		System.out.println();
//		System.out.println();
//
//		System.out.println(text);
		
		
		
		
		// reading the contents from the text using scanner class
//		FileInputStream fis = new FileInputStream(file);
//		Scanner scanner=new Scanner(fis);
		
//		
//		Scanner scanner=new Scanner(file);
////		while(scanner.hasNext()) {
////			System.out.println(scanner.next());
////		}
//		
//		while(scanner.hasNextLine()) {
//			System.out.println(scanner.nextLine());
//			
//		}
//
//		scanner.close();
		
		
		
		/*using filereader class*/
		
//		FileReader fr=new FileReader(file);
//		
//		int asciiCode;
//		String text1=new String();
//		while((asciiCode=fr.read())!=-1) {
//			text1+=(char)asciiCode;
//			//System.out.print((char)asciiCode);
//		}
//		System.out.println(text1);
//
//		fr.close();
		
		
		/* using bufferedreader class */
		
		FileReader fr=new FileReader(file);
		
		BufferedReader br=new BufferedReader(fr);
//		int asciiCode;
//		while((asciiCode=br.read())!=-1) {
//			
//			System.out.print((char)asciiCode);
//		}
		String text1=new String();
		String line=new String();
		while((line=br.readLine())!=null) {
			//System.out.println(line);
			text1+=line+"\n";
		}
		System.out.println(text1);
		
		br.close();

		
	}

}
