package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.University;

public interface IUniversityRepository extends JpaRepository<University, Long> {

}
