package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LanguageController 
{

	@GetMapping("/home")
	public String language(Model model)
	{
		return "home";
	}
}
