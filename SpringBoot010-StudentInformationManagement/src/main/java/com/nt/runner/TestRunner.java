package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbean.Student;

@Component

public class TestRunner  implements CommandLineRunner{

	@Autowired
	Student std;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(std);
	}


}
