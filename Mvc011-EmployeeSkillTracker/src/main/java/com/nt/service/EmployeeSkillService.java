package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.EmployeeSkill;

@Service
public interface EmployeeSkillService {

    EmployeeSkill saveEmployee(EmployeeSkill employee);

    List<EmployeeSkill> getAllEmployees();
}