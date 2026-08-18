package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.EmployeeSkill;
import com.nt.repository.EmployeeSkillRepository;

@Service
public class EmployeeSkillServiceImpl implements EmployeeSkillService {

    private final EmployeeSkillRepository repo;

    public EmployeeSkillServiceImpl(EmployeeSkillRepository repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeSkill saveEmployee(EmployeeSkill employee) {
        return repo.save(employee);
    }

    @Override
    public List<EmployeeSkill> getAllEmployees() {
        return repo.findAll();
    }
}