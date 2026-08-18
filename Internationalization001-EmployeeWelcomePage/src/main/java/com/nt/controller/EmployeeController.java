package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/employee")
    public String showEmployee(Model model) {

        model.addAttribute("employeeName", " Anand Raj");
        model.addAttribute("departmentName", "IT");

        return "employee";
    }
}