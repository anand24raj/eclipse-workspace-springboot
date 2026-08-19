package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.StudentInfo;

@Component
public class TestRunner implements CommandLineRunner {

	final StudentInfo s;

	TestRunner(StudentInfo s) {
		this.s = s;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println(s);
	}

}
