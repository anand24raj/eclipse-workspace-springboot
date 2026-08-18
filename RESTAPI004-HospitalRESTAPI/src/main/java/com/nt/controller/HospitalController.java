package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {

    @GetMapping("/hospital")
    public String hospital() {
        return "Welcome to City Hospital";
    }

    @GetMapping("/hospital/doctor")
    public String doctor() {
        return "Doctor Available: Dr. Anand Raj";
    }

    @GetMapping("/hospital/emergency")
    public String emergency() {
        return "Emergency Services Available 24/7";
    }
}