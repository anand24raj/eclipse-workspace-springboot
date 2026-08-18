package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.HospitalInfo;

@Component
public class TestRunner implements CommandLineRunner
{
	@Autowired
	private HospitalInfo hosp;

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println(hosp);
	}

}
