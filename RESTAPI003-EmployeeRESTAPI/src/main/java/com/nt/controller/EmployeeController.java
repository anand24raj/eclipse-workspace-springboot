package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController 
{
	@GetMapping("/employee")
	public String home() {
		return "Employee Management System";
	}
	
	@GetMapping("/employee/details")
	public String employeeDetail() {
		return "Employee Name: Anand Raj, "
				+ "Department: IT";
		
	}
}
