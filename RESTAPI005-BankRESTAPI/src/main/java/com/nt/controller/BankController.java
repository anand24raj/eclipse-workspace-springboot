package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @GetMapping("/bank")
    public String bank() {
        return "Welcome to Anand Bank";
    }

    @GetMapping("/bank/balance")
    public String balance() {
        return "Your Balance is ₹50,000";
    }

    @GetMapping("/bank/loan")
    public String loan() {
        return "Personal Loan Service Available";
    }
}