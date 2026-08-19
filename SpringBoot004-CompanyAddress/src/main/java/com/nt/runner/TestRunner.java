package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.CompanyInfo;

@Component
public class TestRunner implements CommandLineRunner 
{
	private final CompanyInfo cmp;

	TestRunner(CompanyInfo cmp) {
		this.cmp = cmp;
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.print(cmp);
	}

}
