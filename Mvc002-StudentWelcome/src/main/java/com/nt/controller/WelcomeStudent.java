package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeStudent {

	@GetMapping("/student")
	public String showStudent(Model model) {

		model.addAttribute("message", "Welcome Student");

		return "student";
	}
}