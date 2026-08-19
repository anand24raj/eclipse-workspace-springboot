package com.nt.service;

import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repositry.StudentRepo;

@Service
public class StudentServiceIMPL implements IStudentService {

	final StudentRepo studentRepo;

	StudentServiceIMPL(StudentRepo studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public String addStd(Student student) {
		Student save = studentRepo.save(student);

		return save + "Student Added Succesfully.............";
	}

}
