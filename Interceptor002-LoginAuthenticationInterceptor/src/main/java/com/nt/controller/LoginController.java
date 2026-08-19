package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	// Login Page
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	// Login Check
	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
			Model model) 
	{
		if (username.equals("anand") && "anand123".equals(password)) 
		{
			session.setAttribute("user", username);
			session.setAttribute("password", password);
			
			 System.out.println("Authenticated user     : " + session.getAttribute("user"));
		     System.out.println("Authenticated password : " + session.getAttribute("password"));


			return "redirect:/profile";
		}

		model.addAttribute("error", "Invalid username or password");

		return "login";
	}

	// Protected Page
	@GetMapping("/profile")
	public String profile(HttpSession session, Model model) 
	{
	    	System.out.println("Session User           : " + session.getAttribute("user"));

	    model.addAttribute("username", session.getAttribute("user"));

	    return "profile";
	}

	// Logout
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();

		return "redirect:/login";
	}
}
