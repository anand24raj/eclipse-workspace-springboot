package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController 
{
	@GetMapping("/student")
	public String home() {
		return "Student API Working Successfully";
	}
	
	@GetMapping("/student/name")
	public String studentDetail() {
		return "Student Name: Anand";
	}
}
