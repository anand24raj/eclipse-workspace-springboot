
package com.nt.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;

import com.nt.entity.Employee;
import com.nt.service.EmployeeService;

@Controller
public class EmployeeController {

	private final EmployeeService service;

	EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // Add Employee
    public Employee saveEmployee( Employee emp) 
    {
        return service.addSingleEmployee(emp);
    }

    // View Employee By Id
    public Optional<Employee> getEmployee(Long id) 
    {
        return service.getEmployeeById(id);
    }

    // View All Employees
    public Iterable<Employee> getAllEmployees() 
    {
        return service.getAllEmployees();
    }
}