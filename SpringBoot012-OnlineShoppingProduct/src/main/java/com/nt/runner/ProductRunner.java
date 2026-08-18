package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.Product;

@Component
public class ProductRunner implements CommandLineRunner{

	@Autowired
	Product prod;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(prod);
	}

}
