package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping("/student")
	public String showStudent(Model model) {

		model.addAttribute("name", "Anand Raj");
		model.addAttribute("course", "IT");
		model.addAttribute("city", 50000);

		return "Student";
	}
}
