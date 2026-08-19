package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.EmployeeInfo;

@Component

public class TestRunner implements CommandLineRunner {
	final EmployeeInfo E;

	TestRunner(EmployeeInfo E) {
		this.E = E;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.print(E);

	}

}
