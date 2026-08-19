package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.ProductInfo;


@Component
public class TestRunner implements CommandLineRunner
{
	private final ProductInfo info;

	TestRunner(ProductInfo info) {
		this.info = info;
	}

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println(info);
		
	}
	
	

	

}
