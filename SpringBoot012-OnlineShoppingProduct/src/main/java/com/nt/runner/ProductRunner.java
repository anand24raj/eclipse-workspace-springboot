package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.Product;

@Component
public class ProductRunner implements CommandLineRunner{

	final Product prod;

	ProductRunner(Product prod) {
		this.prod = prod;
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println(prod);
	}

}
