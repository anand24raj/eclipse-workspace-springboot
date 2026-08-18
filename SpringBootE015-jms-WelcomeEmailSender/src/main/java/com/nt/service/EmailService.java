package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;

@Service
public class EmailService {
	@Autowired
	JavaMailSender javaMailSender;

	public void sendWelcomeMail(Employee employee) {
		SimpleMailMessage sms = new SimpleMailMessage();

		String subject = "Welcome to the Organization";

		String body = "Hello " + employee.getName() + ",\n" + "Welcome to our organization.\n"
				+ "We are happy to have you on our team.\n\n" + "Regards,\n" + "HR Team";
		sms.setTo(employee.getEmail());
		sms.setSubject(subject);
		sms.setText(body);
		javaMailSender.send(sms);
		System.out.println("Mail Sended Succesfully .......");
	}
}