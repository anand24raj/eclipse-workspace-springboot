package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.EmployeeInfo;

@Component

public class TestRunner implements CommandLineRunner {
@Autowired
	 EmployeeInfo E;

	@Override
	public void run(String... args) throws Exception {
		System.out.print(E);
		
	}

}
