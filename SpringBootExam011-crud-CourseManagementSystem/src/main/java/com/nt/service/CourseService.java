package com.nt.service;

import java.util.List;

import com.nt.entity.Course;

public interface CourseService {

    Course addingnewcourses(Course course);

    List<Course> viewingallcourses();

    Course searchingcoursesbyID(Integer courseId);
    
    Course updatingCourse(Course course);

    void deletingCourse(Integer courseId);
}