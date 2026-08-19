package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.entity.EmployeeSkill;
import com.nt.service.EmployeeSkillService;

@Controller
public class EmployeeSkillController {

    private final EmployeeSkillService service;

    public EmployeeSkillController(EmployeeSkillService service) {
        this.service = service;
    }

    @GetMapping("/employee/register")
    public String showRegisterPage() {
        return "register";
    }
    
    @RequestMapping(value = "/employee/save", method = {RequestMethod.GET, RequestMethod.POST})
    public String saveEmployee(EmployeeSkill employee) {
    	service.saveEmployee(employee);
    	return "redirect:/employee/all";
    }
    
    @GetMapping("/employee/all")
    public String getAllEmployees(Model model) {
    	model.addAttribute("employees", service.getAllEmployees());
    	return "employees";
    }  
    
}