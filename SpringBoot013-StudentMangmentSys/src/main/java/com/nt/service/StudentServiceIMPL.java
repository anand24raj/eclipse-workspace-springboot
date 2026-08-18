package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repositry.StudentRepo;

@Service
public class StudentServiceIMPL implements IStudentService{

	@Autowired
	StudentRepo studentRepo;
	
	@Override
	public String addStd(Student student) {
		Student save = studentRepo.save(student);
		
		return "Student Added Succesfully.............";
	}

}
