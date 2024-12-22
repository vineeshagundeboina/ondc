package com.corejava;

public class Bank {
	static int currentAmount=1000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Bank bank=new Bank();

		Bank bank=new Bank();
		bank.greetings();
		bank.checkBalance();

		deposit(500);
		System.out.println("after depositing current balance is : "+currentAmount);
		bank.withdraw(300);
		System.out.println("after withdrawing current balance is : "+currentAmount);

		

	}
	
	public void greetings() {
		System.out.println("welcome to banking services");
	}
	
	public static void deposit(int depositAmount) {
		currentAmount=currentAmount+depositAmount;
		System.out.println("amount deposited successfully");
	}
	
	public void withdraw(int withdrawelAmount) {
		currentAmount=currentAmount-withdrawelAmount;
		System.out.println("amount withdrawed successfully");
	}
	
	public int checkBalance() {
		return currentAmount;
	}
	

}
