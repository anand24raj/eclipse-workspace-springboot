package com.nt.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repo;

	EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Employee addEmployee(Employee emp) {
        emp.setNetSalary(emp.getBasicSalary() + emp.getBonus());
        return repo.save(emp);
    }

    @Override
    public Iterable<Employee> viewAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Employee> searchEmployee(Long id) {
        return repo.findById(id);
    }

    @Override
    public Employee updateDetail(Long id, Employee emp) {

        Employee existingEmp = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmp.setBasicSalary(emp.getBasicSalary());
        existingEmp.setBonus(emp.getBonus());
        existingEmp.setDesignation(emp.getDesignation());
        existingEmp.setPerformanceRating(emp.getPerformanceRating());

        existingEmp.setNetSalary(emp.getBasicSalary() + emp.getBonus());

        return repo.save(existingEmp);
    }

    @Override
    public void deleteEmployee(Long id) {

        if (repo.existsById(id)) {
            repo.deleteById(id);
            System.out.println("Employee deleted successfully");
        } 
        else 
        {
            System.out.println("Employee not found");
        }
    }
}