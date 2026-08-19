package com.nt.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.nt.entity.ProjectReport;

@Service
public class MailService {

	private final JavaMailSender mailSender;

	MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendReport(ProjectReport report) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("patel.aj.ajay@gmail.com");
        message.setSubject("Project Daily Status Report");

        String body =
                "Project Name: " + report.getProjectName() + "\n" +
                "Completed Tasks: " + report.getCompletedTasks() + "\n" +
                "Pending Tasks: " + report.getPendingTasks() + "\n\n" +
                "Regards,\n" +
                "Team Lead";

        message.setText(body);

        mailSender.send(message);

        System.out.println("Report email sent successfully.");
    }
}