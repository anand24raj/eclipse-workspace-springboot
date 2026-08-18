package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("gpay")
public class GooglePayPayment implements PaymentService{


	@Value("${companyName}")
	private String companyName;
	
	@Value("${transactionLimit}")
	private Double transactionLimit;
	
	@Value("${paymentType}")
	private String paymentType;
	
	@Override
	public void makePayment() {
		System.out.println("Doing payment using GooglePayPayment..");
		
	}

	@Override
	public void showPaymentDetails() {
		System.out.println(companyName);
		System.out.println(transactionLimit);
		System.out.println(paymentType);
		
	}


}
