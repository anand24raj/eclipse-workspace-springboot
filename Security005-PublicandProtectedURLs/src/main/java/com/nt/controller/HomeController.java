package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {

		model.addAttribute("message", "Welcome to the Public Home Page");

		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {

		model.addAttribute("message", "This is the Public About Page");

		return "about";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {

		model.addAttribute("message", "Welcome to the Protected Dashboard");

		return "dashboard";
	}
}