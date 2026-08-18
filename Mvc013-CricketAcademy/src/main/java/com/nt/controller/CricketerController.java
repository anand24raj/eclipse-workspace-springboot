package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.Cricketer;
import com.nt.service.CricketerService;

@Controller
public class CricketerController {

   private final CricketerService service;

    CricketerController(CricketerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() 
    {
        return "redirect:/viewCricketers";
    }

    @GetMapping("/addCricketer")
    public String addCricketer(Model model) 
    {

        model.addAttribute("cricketer", new Cricketer());

        return "addCricketer";
    }

    @PostMapping("/saveCricketer")
    public String saveCricketer(@ModelAttribute Cricketer cricketer) 
    {

        service.saveCricketer(cricketer);

        return "redirect:/viewCricketers";
    }

    @GetMapping("/viewCricketers")
    public String viewCricketers(Model model) 
    {

        model.addAttribute("list", service.getAllCricketers());

        return "viewCricketers";
    }

    @GetMapping("/editCricketer/{playerId}")
    public String editCricketer(@PathVariable Integer playerId, Model model) 
    {

        model.addAttribute("cricketer",
                service.getCricketerById(playerId));

        return "editCricketer";
    }

    @PostMapping("/updateCricketer")
    public String updateCricketer(@ModelAttribute Cricketer cricketer) 
    {

        service.updateCricketer(cricketer);

        return "redirect:/viewCricketers";
    }

    @GetMapping("/deleteCricketer/{playerId}")
    public String deleteCricketer(@PathVariable Integer playerId) 
    {

        service.deleteCricketer(playerId);

        return "redirect:/viewCricketers";
    }
}