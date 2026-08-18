package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.Payment;

@Component
public class PaymentRunner implements CommandLineRunner {

	@Autowired
    private  Payment payment;

    @Override
    public void run(String... args) throws Exception 
    {
        System.out.println("===== Payment Gateway Details =====");
        payment.paymentDetails();
    }
}