package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.Student;

@Controller
public class StudentController {

	@GetMapping("/")
	public String showStudentForm() 
	{
		return "student";
	}

	@PostMapping("/post")
	public String display(@ModelAttribute Student std, Map<String, Student> map) 
	{
		map.put("stdInfo", std);
		return "view";
	}
}