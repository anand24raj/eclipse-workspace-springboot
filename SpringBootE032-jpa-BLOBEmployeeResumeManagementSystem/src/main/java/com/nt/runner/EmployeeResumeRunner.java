package com.nt.runner;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.EmployeeResume;
import com.nt.service.EmployeeResumeSevice;

@Component
public class EmployeeResumeRunner implements CommandLineRunner {

	private final EmployeeResumeSevice service;

	EmployeeResumeRunner(EmployeeResumeSevice service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			IO.println("\n========== Employee Resume Management System ==========");
			IO.println("1. Save Employee Resume");
			IO.println("2. View Employee Resume by ID");
			IO.println("3. View All Employee Resumes");
			IO.println("4. Write files in output Resumes");
			IO.println("5. Delete Employee Resume");
			IO.println("6. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice) {

			case 1 -> {
				String employeeName = IO.readln("Enter Employee Name : ");
				String designation = IO.readln("Enter Designation : ");
				String resumeContent = IO.readln("Enter text Content path : ");
				String picContent = IO.readln("Enter pic Content path : ");

				EmployeeResume resume = new EmployeeResume(null, employeeName, designation,
						Files.readString(Path.of(resumeContent), StandardCharsets.UTF_8),
						Files.readAllBytes(Path.of(picContent)));

				String result = service.saveEmployeeResume(resume);
				IO.println(result);
			}

			case 2 -> {
				Long employeeId = Long.parseLong(IO.readln("Enter Employee ID : "));

				EmployeeResume resume = service.viewEmployeeResumebyId(employeeId);

				if (resume != null) {
					displayResume(resume);
				} else {
					IO.println("Employee Resume ID Not Found");
				}
			}

			case 3 -> {
				IO.println("\nAll Employee Resumes:");

				boolean found = false;

				for (EmployeeResume resume : service.viewAllEmployeeResumes()) {
					displayResume(resume);
					found = true;
				}

				if (!found) {
					IO.println("No Employee Resumes Found");
				}
			}

			case 4 -> {
				Long employeeId = Long.parseLong(IO.readln("Enter Employee ID : "));
				String resumeContent = IO.readln("Enter text Content path : ");
				String picContent = IO.readln("Enter pic Content path : ");

				EmployeeResume resume = service.viewEmployeeResumebyId(employeeId);

				Files.writeString(Path.of(resumeContent), resume.getResumeContent(), StandardCharsets.UTF_8);

				Files.write(Path.of(picContent), resume.getPic());
			}
			case 5 -> {
				Long employeeId = Long.parseLong(IO.readln("Enter Employee ID : "));
				service.deleteEmployeeResume(employeeId);
			}

			case 6 -> {
				IO.println("Application Closed Successfully");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}
	}

	private void displayResume(EmployeeResume resume) {
		IO.println("--------------------------------");
		IO.println("Employee Id      : " + resume.getEmployeeId());
		IO.println("Employee Name    : " + resume.getEmployeeName());
		IO.println("Designation      : " + resume.getDesignation());
		IO.println("Resume Content   : " + resume.getResumeContent());
		IO.println("Resume pic   : " + resume.getPic());
		IO.println("--------------------------------");
	}
}