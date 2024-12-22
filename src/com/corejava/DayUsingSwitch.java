package com.corejava;

public class DayUsingSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String day="friday";
		switch(day) {
		case "monday":
		case "tuesday":
		case "wednesday":
		case "thursday":
		case "friday":{
			System.out.println("uff");
			break;
		}
		case "saturday":
		case "sunday":{
			System.out.println("yaayy");
		}
		 
		}

	}

}
