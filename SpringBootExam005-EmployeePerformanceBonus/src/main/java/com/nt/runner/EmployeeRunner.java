package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.EmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	final EmployeeService employeeService;

	EmployeeRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception 
    {
        employeeService.calculateBonus();
    }
}
