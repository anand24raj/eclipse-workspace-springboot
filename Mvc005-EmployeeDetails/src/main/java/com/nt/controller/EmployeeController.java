package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/employee")
    public String showEmployee(Model model) {

        model.addAttribute("id", "101");
        model.addAttribute("name", "Anand Raj");
        model.addAttribute("department", "IT");
        model.addAttribute("salary", 50000);

        return "Employee";
    }
}
