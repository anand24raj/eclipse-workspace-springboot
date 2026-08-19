package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

import com.nt.model.LoginForm;
import com.nt.validator.LoginValidator;

@Controller
public class LoginController {

	private final LoginValidator loginValidator;

	public LoginController(LoginValidator loginValidator) {
		this.loginValidator = loginValidator;
	}

	// Login page
	@GetMapping("/login")
	public String loginPage(Model model) {

		model.addAttribute("loginForm", new LoginForm());

		return "login";
	}

	// Login submit
	@PostMapping("/login")
	public String login(@ModelAttribute("loginForm") LoginForm loginForm, BindingResult result, Model model) {

		loginValidator.validate(loginForm, result);

		if (result.hasErrors()) {
			return "login";
		}

		if ("anand".equals(loginForm.getUsername()) && "anand123".equals(loginForm.getPassword())) {

			model.addAttribute("username", loginForm.getUsername());

			return "home";
		}

		result.reject("validation.invalid.credentials");

		return "login";
	}

	// Logout page
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
}