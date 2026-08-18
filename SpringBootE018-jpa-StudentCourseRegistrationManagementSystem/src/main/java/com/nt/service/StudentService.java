package com.nt.service;

import com.nt.entity.Student;

public interface StudentService {

	public void registerStudent(Student stud);

    Iterable<Student> getAllStudents();

    public Student getStudentById(Long sid);

    public String updateCourse(String courseName, Long sid);

    public void deleteStudent(Long sid);

    public long countStudents();
}
