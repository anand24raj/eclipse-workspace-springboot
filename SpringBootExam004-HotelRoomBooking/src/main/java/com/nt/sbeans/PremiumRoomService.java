package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("premium")
public class PremiumRoomService implements HotelService 
{
    @Value("${customerName}")
    private String customerName;

    @Value("${roomRent}")
    private double roomRent;

    @Value("${days}")
    private int days;

    @Value("${foodCharge}")
    private double foodCharge;

    @Value("${laundryCharge}")
    private double laundryCharge;

    @Override
    public void generateBill() 
    {
        double roomCost = roomRent * days;
        double subTotal = roomCost + foodCharge + laundryCharge;
        double gst = subTotal * 18 / 100;
        double finalBill = subTotal + gst;

        System.out.println("===== NORMAL ROOM BILL =====");
        System.out.println("Customer Name   : " + customerName);
        System.out.println("Room Rent       : " + roomRent);
        System.out.println("Days Stayed     : " + days);
        System.out.println("Room Cost       : " + roomCost);
        System.out.println("Food Charge     : " + foodCharge);
        System.out.println("Laundry Charge  : " + laundryCharge);
        System.out.println("Subtotal        : " + subTotal);
        System.out.println("GST (18%)       : " + gst);
        System.out.println("Final Bill      : " + finalBill);
    }
}