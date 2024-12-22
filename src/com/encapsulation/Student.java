package com.encapsulation;

public class Student {
	private int rollNo;
	private String name;
	private boolean isAttended;
	
	public Student(int rollNo) {
		this.rollNo=rollNo;
		
	}
	
	public void setStudentAttendance(boolean attendance) {
		if(!isAttended) {
			isAttended=attendance;
			System.out.println(" teacher assigned student attendance ");
		}
	}
	
	public boolean getStudentAttendance() {
		System.out.println(" teacher accessed student attendance ");
		return isAttended;
	}

}
