package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping("/student")
	public String student(Model model) {

		model.addAttribute("studentName", " Anand Raj");
		model.addAttribute("courseName", "Java Full Stack");

		return "student";
	}
}
