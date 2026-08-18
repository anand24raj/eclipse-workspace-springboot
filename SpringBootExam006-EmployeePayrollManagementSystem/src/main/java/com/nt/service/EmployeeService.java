package com.nt.service;

import java.util.Optional;
import com.nt.entity.Employee;

public interface EmployeeService {

    Employee addEmployee(Employee emp);

    Iterable<Employee> viewAll();

    Optional<Employee> searchEmployee(Long id);

    Employee updateDetail(Long id, Employee emp);

    void deleteEmployee(Long id);
}