package com.corejava;

import java.util.Arrays;
import java.util.Scanner;

public class StringsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1="vineesha";
//		
//		String s3="hi";
//		String s2=new String("hello"); //it will print value,that is why string is called literal
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s1+s3);  //concatination
//		System.out.println(s3);
//		StringsPractice c=new StringsPractice();  //it will give hashcode
//		System.out.println(c);
		
//		String s1="hello";
//		String s2=new String("hello");
//		String s3="hello";
//		System.out.println(s1==s2);  //it will compare the addresses(references)
//		System.out.println(s1.equals(s2));  //it will compare the contents of two strings
//		System.out.println(s1==s3);
//		
		
		
		//methods
		
//		String s1="hello";
//		String s2=" Hell^o w^orld  ";
//		String s3="HEELO";
		
		
//		System.out.println(s1.equals(s2));
//		System.out.println(s1.equalsIgnoreCase(s2));
//		System.out.println(s1.concat(s3));
//		System.out.println(s1.contains("He"));
//		System.out.println(s1.startsWith("e"));
//		
//		System.out.println(s1.endsWith("ge"));
//		
//		System.out.println(s1.endsWith("lo"));
//		
//		System.out.println(s1.toUpperCase());
//		System.out.println(s3.toLowerCase());
//		System.out.println(s2.trim());
//		System.out.println(s2.length());
//		System.out.println(s2.trim().length());
//		char[] c=s1.toCharArray();
//		System.out.println(c);
//		System.out.println(s2.indexOf("9"));
//		System.out.println(s2.lastIndexOf("l"));
//		System.out.println(s2.substring(2));
//		System.out.println(s2.substring(2,5));
//		System.out.println(Arrays.toString(s2.split("\\^")));
//		System.out.println(s2.charAt(2));
//		System.out.println(s2.replace("o", "zk"));
//		
//		String s="132334";
//		int i=Integer.valueOf(s);
//		System.out.println(i);
//		int j=87897;
//		System.out.println(String.valueOf(j));
//		
//		System.out.println();
//		
//		String str;
//		String str1="  ";
//		String str2="";
////		
////		System.out.println(str.length());
////		System.out.println(str.isEmpty());
//		
//		System.out.println(str1.length());
//		System.out.println(str1.isEmpty());
//		System.out.println(str1.isBlank());
//		
//		
	
		//Assignment
		
//		String s="java is super";
//		System.out.println(s.length());
//		String[] c=s.split(" ");
//		System.out.println(Arrays.toString(c));
//		System.out.println(c.length);
		
		
		
//		System.out.println("enter the string");
//		
//		Scanner input=new Scanner(System.in);
//		
//		
//		String s=input.nextLine();
//		System.out.println(s);
//		
//		int c=countingNoOfChars(s);
//		System.out.println("ddff : "+c);
//		
//	}
//		
//		public static int countingNoOfChars(String str) {
//		char[] c=str.toCharArray();
//		
//		int count=0;
//		for(int i=0;i<c.length;i++) {
//			if(c[i]=='l') {
//				count++;
//			}
//		}
//		
//		System.out.println(count);
//		return count;
//	
		
		
//		String s="   hello world  ";
//		System.out.println(s.trim());
//		
		
//		String s="java is super";
//		
//		String[] words=s.split(" ");
//		System.out.println(words);
//		for(int i=0;i<words.length;i++) {
//			String a=reverseOfString(words[i]);
//			System.out.print(a+" ");
//		}
//		
//	}
//	
//	public static String reverseOfString(String str) {
//	
//		String reversed="";
//		for(int i=0;i<str.length();i++) {
//			ch=str.charAt(i);
//			reversed=ch+reversed;
//		}
//		return reversed;
//	}
//	
//	static String reversed="";
//	static char ch;
		
		
//		String s="this is a test string!!";
//		String[] s1=s.split(" ");
//		for(int i=0;i<s1.length;i++) {
//			if(i%2==0) {
//				String str2=upper(s1[i]);
//				System.out.print(str2+" ");
//			}
//			else {
//				String str3=reverse(s1[i]);
//				System.out.print(str3+" ");
//			}
//		}
//		
//		
//		
//		
//	}
//	static String str1="";
//	public static String upper(String str) {
//		str1=str.toUpperCase();
//		return str1;
//	}
//	
//	static String reversed="";
//	static char ch;
//	public static String reverse(String st) {
//		reversed="";
//		for(int i=0;i<st.length();i++) {
//			ch=st.charAt(i);
//			reversed=ch+reversed;
//		}
//		return reversed;
//
//	}

		
//		String s="AD5Fa2D@G$%JHgh443hg&";
//		int upper=0;
//		int lower=0;
//		int special=0;
//		int digit=0;
//		
//		for(int i=0;i<s.length();i++) {
//			char ch=s.charAt(i);
//			if(Character.isUpperCase(ch)) {
//				upper++;
//				
//			}
//			else if(Character.isLowerCase(ch)){
//				lower++;
//			}
//			
//			else if(Character.isDigit(ch)) {
//				digit++;
//			}
//			
//			else if(Character.isWhitespace(ch)){
//				
//			}
//			else {
//				special++;
//			}
//			
//		}
//		
//		System.out.println("upper : "+upper);
//		System.out.println("lower : "+lower);
//		System.out.println("special : "+special);
//		System.out.println("digit : "+digit);
//		
		
		
//		String s="java is super keka easy and awesome";
//		String[] s1=s.split(" ");
//		String[] oddWords=new String[(s1.length)/2];
//		int j=0;
//		for(int i=0;i<s1.length;i++) {
//			if(i%2!=0) {
//				oddWords[j]=s1[i];
//				j++;
//			}
//		}
//		
//		System.out.println(Arrays.toString(oddWords));
		
		
		String s="Hello hi how are you worldfgh";
		String[] st=s.split(" ");
		//int[] len=new int[s.length()];
		String maxLengthWord=st[0];
		int max=st[0].length();
		for(String word:st) {
			if(word.length()>max) {
				max=word.length();
				maxLengthWord=word;
			}
			
			
		}
		System.out.println(maxLengthWord);	
		//System.out.println("hj");

		
		
		
		
	}
}
