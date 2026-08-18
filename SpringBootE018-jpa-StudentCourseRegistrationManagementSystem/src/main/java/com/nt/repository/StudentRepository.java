package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
