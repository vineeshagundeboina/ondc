package com.qd.library.management.system.service;

import org.springframework.stereotype.Component;

public interface PaymentService {
	public void processPayment();

}

@Component("paypal")
class PaypalService implements PaymentService{

	@Override
	public void processPayment() {
		// TODO Auto-generated method stub
		System.out.println("processing payment through paypal");
	}
	
}

@Component("creditcard")
class CreditcardService implements PaymentService{
	@Override
	public void processPayment() {
		System.out.println("processing payment through creditcard");
	}
}
 