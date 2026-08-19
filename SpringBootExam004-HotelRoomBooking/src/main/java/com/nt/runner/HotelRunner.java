package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.HotelService;


@Component
public class HotelRunner implements CommandLineRunner 
{
	final HotelService hotelService;

	HotelRunner(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public void run(String... args) throws Exception 
    {
        hotelService.generateBill();
    }
}
