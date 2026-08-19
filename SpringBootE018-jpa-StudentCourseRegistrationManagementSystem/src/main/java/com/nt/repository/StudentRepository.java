package com.nt.repository;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
