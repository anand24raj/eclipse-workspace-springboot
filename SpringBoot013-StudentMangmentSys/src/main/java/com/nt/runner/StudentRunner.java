package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Student;
import com.nt.service.IStudentService;
@Component
public class StudentRunner implements CommandLineRunner {

	final IStudentService iStudentService;

	StudentRunner(IStudentService iStudentService) {
		this.iStudentService = iStudentService;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	Student s1 =new Student("Rj", "BR");
		String std = iStudentService.addStd(s1);
		System.out.println(std);

	}

}
