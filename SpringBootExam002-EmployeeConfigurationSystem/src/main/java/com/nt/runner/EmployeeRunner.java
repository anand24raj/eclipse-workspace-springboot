package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.EmployeeConfig;

@Component
public class EmployeeRunner implements CommandLineRunner 
{
	@Autowired
	EmployeeConfig employee;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("===== Employee Details =====");
        System.out.println("Employee ID      : " + employee.getId());
        System.out.println("Employee Name    : " + employee.getName());
        System.out.println("Department       : " + employee.getDepartment());
        System.out.println("Salary           : " + employee.getSalary());
        System.out.println("Designation      : " + employee.getDesignation());
    }

}
