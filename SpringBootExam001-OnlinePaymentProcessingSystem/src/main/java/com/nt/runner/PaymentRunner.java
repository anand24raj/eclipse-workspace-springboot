package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.Payment;

@Component
public class PaymentRunner implements CommandLineRunner {

	private final Payment payment;

	PaymentRunner(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void run(String... args) throws Exception 
    {
        System.out.println("===== Payment Gateway Details =====");
        payment.paymentDetails();
    }
}