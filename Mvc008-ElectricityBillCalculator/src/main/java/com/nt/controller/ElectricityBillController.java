package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ElectricityBillController {

	@GetMapping("/")
	public String showBillForm() {
		return "bill";
	}

	@PostMapping("/calculateBill")
	public String calculateBill(@RequestParam String customerName, @RequestParam int units, Model model) {

		int totalBill = units * 8;

		model.addAttribute("customerName", customerName);
		model.addAttribute("units", units);
		model.addAttribute("totalBill", totalBill);

		return "billResult";
	}
}