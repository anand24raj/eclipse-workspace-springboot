package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.entity.FestivalPass;

@Controller
public class FestivalController {

    @GetMapping("/festival")
    public String showForm(Model model) 
    {
        model.addAttribute("festivalPass", new FestivalPass());
        return "festival-form";
    }

    @PostMapping("/festival")
    public String submitForm(@ModelAttribute("festivalPass") FestivalPass pass, Model model) 
    {
        model.addAttribute("festivalPass", pass);
        return "festival-success";
    }
}