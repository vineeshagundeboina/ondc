package assessment.pra;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
//		Museum[] museums=new Museum[] {
//				new Museum(1,"a","location A",3,true),
//				new Museum(2,"b","location B",3.5,true),
//				new Museum(3,"c","location C",2.5,true)
//		};
//		
//		double avgRating=4.0;
//		int count=getCountOfResearchBasedOnRating(museums,avgRating);
//		System.out.println("count of research museums"+count);
//		
//		
//		// TODO Auto-generated method stub
//	}
//		
//		private static int getCountOfResearchBasedOnRating(Museum[] museums,double avgRating) {
//			int count=0;
//			for(Museum museum:museums)
//			if(museum.isResearchCentre()&&museum.getRating()<=avgRating) {
//				count++;
//			}
//			return count;
//		
//
//	}
//	
		Scanner sc=new Scanner(System.in);
		System.out.println("enter museum fields");
		
		Museum[] m=new Museum[5];
		for(int i=0;i<5;i++) {
			int a=sc.nextInt();
			sc.nextLine();
			String b=sc.nextLine();
			String c=sc.nextLine();
			double d=sc.nextDouble();
			boolean e=sc.nextBoolean();
			m[i]=new Museum(a, b, c, d, e);
		}
		
		double in_d=sc.nextDouble();
		sc.nextLine();
		String in_city=sc.nextLine();
		count(m,in_d);
		search(m,in_city);
		

  }
	
	public static void count(Museum[] m,double in_d) {
		int count=0;
		for(int i=0;i<m.length;i++) {
			if(m[i].isResearchCentre()&&m[i].getRating()<=in_d) {
				count++;
				
			}
		}
		if(count==0) {
			System.out.println("No matching museums found");
		}
		else {
			System.out.println(count);
		}
	}
	public static void search(Museum[] m,String in_city) {
		int count=0;
		for(int i=0;i<m.length;i++) {
			if(m[i].getMuseumLocation().equalsIgnoreCase(in_city)) {
				count++;
			}
		}
		if(count==0) System.out.println("there is no matching museum in given location");
		else {
			double[] arr=new double[count];
			int a=0;
			for(int i=0;i<m.length;i++) {
				if(m[i].getMuseumLocation().equalsIgnoreCase(in_city)) {
					arr[a]=m[i].getRating();
					a++;
				}
				
			}
			Arrays.sort(arr);
			for(int i=0;i<count;i++) {
				for(int j=0;j<m.length;j++) {
					if(arr[i]==m[j].getRating()) {
						System.out.println(m[j].getMuseumName()+",");
						System.out.println(m[j].getRating());
					}
				}
			}
		}
	}
	

}
