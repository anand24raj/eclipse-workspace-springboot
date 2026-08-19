package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.HospitalInfo;

@Component
public class TestRunner implements CommandLineRunner
{
	private final HospitalInfo hosp;

	TestRunner(HospitalInfo hosp) {
		this.hosp = hosp;
	}

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println(hosp);
	}

}
