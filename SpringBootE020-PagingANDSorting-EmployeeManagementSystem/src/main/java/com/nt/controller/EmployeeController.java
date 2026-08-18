
package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import com.nt.entity.Employee;
import com.nt.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService service;

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
    public Page<Employee> getEmployeesByPageController(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
    	return 	service.getEmployeesByPage(pageNumber, pageSize);
	}
    public List<Employee> getEmployeesSortedBySalaryController(boolean flag, String name) {
		// TODO Auto-generated method stub
		
		return service.getEmployeesSortedBySalary(flag, name);
				
	}
}