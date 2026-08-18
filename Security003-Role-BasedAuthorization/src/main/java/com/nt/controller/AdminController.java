package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("message", "Welcome to Admin Page");
		return "admin";
	}
}
