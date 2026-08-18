package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.HotelService;


@Component
public class HotelRunner implements CommandLineRunner 
{
	@Autowired
    HotelService hotelService;

    @Override
    public void run(String... args) throws Exception 
    {
        hotelService.generateBill();
    }
}
