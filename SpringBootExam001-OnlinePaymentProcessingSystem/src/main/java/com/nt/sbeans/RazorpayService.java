package com.nt.sbeans;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Profile("india")
public class RazorpayService implements Payment {

    @Value("${gateway}")
    private String gateway;

    @Value("${charge}")
    private double charge;

    @Value("${currency}")
    private String currency;

    @Override
    public void paymentDetails() {

        System.out.println("Payment Gateway : " + gateway);
        System.out.println("Transaction Charge : " + charge + "%");
        System.out.println("Currency : " + currency);
    }
}