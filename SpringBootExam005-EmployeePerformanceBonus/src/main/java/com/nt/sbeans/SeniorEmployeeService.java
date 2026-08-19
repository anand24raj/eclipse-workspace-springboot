package com.nt.sbeans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.nt.configuration.EmployeeConfig;

@Component
@Profile("senior")
public class SeniorEmployeeService implements EmployeeService {

	final EmployeeConfig employee;

	   SeniorEmployeeService(EmployeeConfig employee) {
        this.employee = employee;
    }


    @Override
    public void calculateBonus() 
    {
        double annualSalary = employee.getSalary() * 12;
        double bonus = annualSalary * 20 / 100;
        double finalPackage = annualSalary + bonus;

        System.out.println("===== SENIOR EMPLOYEE =====");
        System.out.println("Employee ID      : " + employee.getId());
        System.out.println("Employee Name    : " + employee.getName());
        System.out.println("Monthly Salary   : " + employee.getSalary());
        System.out.println("Rating           : " + employee.getRating());
        System.out.println("Experience       : " + employee.getExperience());
        System.out.println("Annual Salary    : " + annualSalary);
        System.out.println("Bonus (20%)      : " + bonus);
        System.out.println("Final Package    : " + finalPackage);
    }
}