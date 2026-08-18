package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.UniversityConfig;
 
@Component
public class UniversityRunner implements CommandLineRunner 
{	
	@Autowired
    UniversityConfig university;

    @Override
    public void run(String... args) throws Exception 
    {
        System.out.println("====================================");
        System.out.println(" UNIVERSITY ADMISSION INFORMATION");
        System.out.println("====================================");

        System.out.println("University ID      : " + university.getId());
        System.out.println("University Name    : " + university.getName());
        System.out.println("Location           : " + university.getLocation());
        System.out.println("Admission Fee      : " + university.getAdmissionFee());
        System.out.println("Contact Number     : " + university.getContact());
        System.out.println("Website URL        : " + university.getWebsite());

        System.out.println("====================================");
    }
}
