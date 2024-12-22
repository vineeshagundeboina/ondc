package com.encapsulation;

public class Teacher {
	public static void main(String[] args) {
		Student s=new Student(101);
//		s.isAttended=true;
//		System.out.println(" teacher gave attendance ");
		s.setStudentAttendance(false);
		s.getStudentAttendance();
	}

}
