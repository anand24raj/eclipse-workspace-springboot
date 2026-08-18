package com.nt.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

	
	@Autowired
	JavaMailSender sender;
	
	public void sendOfferLetter(Employee employee) throws MessagingException, FileNotFoundException
	{
		
		MimeMessage msg=sender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(msg,true);
		
		helper.setTo(employee.getEmployeeEmail());
		
		helper.setSubject("Offer Letter - Software Developer \n"
				+ "");
		String body="Dear "+employee.getEmployeeName()+" Congratulations! \n"
				+ "We are pleased to offer you the position of Software Developer. with Salary 1 cr. \n"+
				"Please find the attached Offer Letter PDF.\n"+
				
				"Regards, \n"
				+ "HR Team\r\n"
				+ "ABC Technologies\r\n"
				+ "Technical Requirements\r\n";
		
		
		
		  helper.setText(body);
		//String file="C:\\Users\\anand\\OneDrive\\Desktop\\Java Notes\\Offerletter.pdf";
		
		File fis=new File("C:\\Users\\anand\\OneDrive\\Desktop\\Java Notes\\Offerletter.pdf");
		
		
		  helper.addAttachment("Offerletter.pdf", fis);
		  sender.send(msg);
		  System.out.println("mail");
	}

}
