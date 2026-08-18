package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long>{

}
