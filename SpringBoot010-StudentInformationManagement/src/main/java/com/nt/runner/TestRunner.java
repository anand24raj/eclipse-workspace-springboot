package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbean.Student;

@Component

public class TestRunner  implements CommandLineRunner{

	final Student std;

	TestRunner(Student std) {
		this.std = std;
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(std);
	}


}
