package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.Employee;
@Component
public class EmployeeRunner implements CommandLineRunner {

	final Employee emp;

	EmployeeRunner(Employee emp) {
		this.emp = emp;
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(emp);
	}

}
