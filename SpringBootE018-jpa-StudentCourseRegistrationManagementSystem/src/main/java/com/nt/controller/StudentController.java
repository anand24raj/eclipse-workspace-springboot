package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.entity.Student;
import com.nt.service.StudentService;

@Controller
public class StudentController  {

	@Autowired
	StudentService stdsrv;
	
	public void registerStudents(Student stud)
	{
		stdsrv.registerStudent(stud);
		System.out.println("Student register successfully ...");
	}
	 Iterable<Student> getAllStudent()
	 {
		 System.out.println("Reterive all the data");
		return stdsrv.getAllStudents();
		
	 }
	 public Student getStudentById_(Long sid)
	 {
		 return stdsrv.getStudentById(sid);
	 }
	 public String updateCourses(String courseName, Long sid)
	 {
		 return stdsrv.updateCourse(courseName, sid);
		 
	 }
	 public void deleteStudent(Long sid)
	 {
		 stdsrv.deleteStudent(sid); 
	 }
	 public long countStudent()
	 {
		 return stdsrv.countStudents();
	 }
	
	
	
	
}
