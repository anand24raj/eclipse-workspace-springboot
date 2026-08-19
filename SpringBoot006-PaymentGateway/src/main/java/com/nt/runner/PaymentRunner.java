package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.PaymentService;

@Component
public class PaymentRunner implements CommandLineRunner{

	final PaymentService paymentService;

	PaymentRunner(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		paymentService.makePayment();
		paymentService.showPaymentDetails();
	}

}
