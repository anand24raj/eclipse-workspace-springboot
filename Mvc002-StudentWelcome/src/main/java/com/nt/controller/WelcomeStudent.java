package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeStudent {

    @RequestMapping("/student")
    public String showStudent(Model model) {

        model.addAttribute("message", "Welcome Student");

        return "student";
    }
}