package com.corejava;

public class MultidimentionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[][] arr=new int[3][2];
//		arr[0][0]=3;
//		arr[0][1]=2;
//		arr[1][0]=1;
//		arr[1][1]=4;
//		arr[2][0]=5;
//		arr[2][1]=6;
//		System.out.println(arr[0][1]);
//		System.out.println(arr[1][0]);
//		System.out.println();
		
//		for(int i=0;i<arr.length;i++) {
//			 int[] singleRow=arr[i];
//			 for(int j=0;j<singleRow.length;j++) {
//				 System.out.print(singleRow[j]+ "  ");
//			 }
//			 System.out.println();
//		}
		
		//int[][] arr= {{1,2},{3,4},{5,6}};
//		int[][] arr=new int[][] {{1,2},{3,4},{5,6}};
//		int size=0;
//		for(int i=0;i<arr.length;i++) {
//			size+=arr[i].length;
//			for(int j=0;j<arr[i].length;j++) {
//				System.out.print(arr[i][j]+"  ");
//			}
//			System.out.println();
//		}
//		System.out.println("size "+size);

		
		
//		int[][] arr=new int[3][];
//		arr[0]=new int[] {1,2};
//		arr[1]=new int[] {3,4,5,6,6};
//		arr[2]=new int[] {33,45,6};
//		
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i].length;j++) {
//				System.out.print(arr[i][j]+"  ");
//			}
//			System.out.println();
//		}
//		
//		int[][] arr=new int[][] {{1,2,3},{4,5,6},{7,8,9}};
//		int sum=0;
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i].length;j++) {
//				sum+=arr[i][j];
//				System.out.print(arr[i][j]+"  ");
//			}
//			System.out.println();
//		}
//		System.out.println("sum : "+sum);
		
		int sum=0;
		int numberOfElements=0;
		int[][] arr=new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		for(int[] singledimarr:arr) {
			for(int value:singledimarr) {
				sum+=value;
				numberOfElements++;
			}
		}
		System.out.println("sum of elements: "+sum);
		System.out.println("avg of elements : "+(sum/numberOfElements));
		
		
	}

}
