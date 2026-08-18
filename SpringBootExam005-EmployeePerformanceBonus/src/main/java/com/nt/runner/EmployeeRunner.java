package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.EmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
    EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception 
    {
        employeeService.calculateBonus();
    }
}
