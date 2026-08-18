package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.service.MailService;


@Component
public class TestRunner implements CommandLineRunner {

	 @Autowired
	 MailService service;
	@Override
	public void run(String... args) throws Exception {
		
		Employee raj=new Employee();
		raj.setDesignation("Hr");
		raj.setEmployeeEmail("patel.aj.ajay@gmail.com");
		raj.setEmployeeName(" Ajay Patel");
		
		service.sendOfferLetter(raj);
		
		System.out.println("mail send succ");
		
	}

}
