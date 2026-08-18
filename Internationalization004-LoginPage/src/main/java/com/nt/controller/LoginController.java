package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.LoginForm;
import com.nt.validator.LoginValidator;

@Controller
public class LoginController {

	private final LoginValidator loginValidator;

	public LoginController(LoginValidator loginValidator) {

		this.loginValidator = loginValidator;

	}

	@GetMapping("/home")
	public String home() {

		return "home";

	}

	@GetMapping("/login")
	public String loginPage(Model model) {

		model.addAttribute("loginForm", new LoginForm());

		return "login";

	}

	@PostMapping("/login")
	public String login(@ModelAttribute LoginForm loginForm, BindingResult result, Model model) {

		loginValidator.validate(loginForm, result);

		if (result.hasErrors()) {

			return "login";

		}

		boolean valid = "anand".equals(loginForm.getUsername()) && "anand123".equals(loginForm.getPassword());

		if (!valid) {

			result.reject("validation.invalid.credentials");

			return "login";

		}

		model.addAttribute("loginSuccess", true);

		return "redirect:/home";

	}

}