package com.qd.library.management.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qd.library.management.system.service.PaymentService;

@RestController
public class PaymentController {
	
	
	@Autowired
	
	@Qualifier("creditcard")
	private PaymentService paymentService;
	
	
	@GetMapping("/pay")
	public String pay() {
		paymentService.processPayment();
		return "payment processed";
	}

}
