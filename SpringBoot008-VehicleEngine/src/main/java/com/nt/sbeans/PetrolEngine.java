package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("petrol")
public class PetrolEngine implements Engine 
{
    @Value("${vehicle.enginePower}")
    private String enginePower;

    @Value("${vehicle.mileage}")
    private String mileage;

    @Value("${vehicle.companyName}")
    private String companyName;
    
    @Override
    public void startEngine() {
        System.out.println("Petrol Engine Started...");
    }

    public void showEngineDetails() 
    {
    	
        System.out.println("Company Name : " + companyName);
        System.out.println("Engine Power : " + enginePower);
        System.out.println("Mileage      : " + mileage);
    }


}