package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {

	@GetMapping("/employee/{id}")
	public String showEmployee(@PathVariable("id") Integer id, Model model) {

		model.addAttribute("empId", id);
		model.addAttribute("empName", "Anand Raj");
		model.addAttribute("department", "Software Development");
		model.addAttribute("salary", 55000);

		return "employee";
	}
}