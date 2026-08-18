package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.PaymentService;

@Component
public class PaymentRunner implements CommandLineRunner{

	@Autowired
	PaymentService paymentService;
	
	@Override
	public void run(String... args) throws Exception {
		paymentService.makePayment();
		paymentService.showPaymentDetails();
	}

}
