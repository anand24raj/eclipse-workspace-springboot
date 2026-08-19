package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nt.entity.ProjectReport;
import com.nt.service.MailService;

@SpringBootApplication
public class DailyReportApplication implements CommandLineRunner {

	private final MailService mailService;

	DailyReportApplication(MailService mailService) {
        this.mailService = mailService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DailyReportApplication.class, args);
    }

    @Override
    public void run(String... args) {

        ProjectReport report = new ProjectReport(
                "Employee Management System",
                15,
                5
        );

        mailService.sendReport(report);
    }
}
