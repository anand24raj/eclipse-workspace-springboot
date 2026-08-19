package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
