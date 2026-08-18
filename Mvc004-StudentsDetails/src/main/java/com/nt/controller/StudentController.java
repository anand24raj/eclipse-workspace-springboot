package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/student")
    public String showStudent(Model model) {

        model.addAttribute("name", "Anand Raj");
        model.addAttribute("course", "IT");
        model.addAttribute("city", 50000);

        return "Student";
    }
}
