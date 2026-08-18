package com.nt.runner;

import org.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.*;

@Component
public class TestRunner implements CommandLineRunner{

	@Autowired
	StudentInfo s;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(s);
	}

} 
