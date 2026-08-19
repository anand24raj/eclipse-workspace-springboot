package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.EmployeeResume;

public interface EmployeeResumeRepository extends JpaRepository<EmployeeResume, Long> {

}
