package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Employee;
import com.nt.service.EmailService;

@SpringBootApplication
public class SpringBootE014JmsWelcomeEmailSenderApplication {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootE014JmsWelcomeEmailSenderApplication.class, args);
		

        Employee employee = ctx.getBean(Employee.class);
        employee.setEmail("patel.aj.ajay@gmail.com");
        employee.setName("patel");

        EmailService emailService = ctx.getBean(EmailService.class);
        emailService.sendWelcomeMail(employee);
	}

}
