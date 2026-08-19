package com.nt.runner;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.controller.ProductController;
import com.nt.entity.Product;

@Component

public class ConsoleApplicationRunner implements CommandLineRunner {
	Scanner sc = new Scanner(System.in);
	private final ProductController cont;

	ConsoleApplicationRunner(ProductController cont) {
		this.cont = cont;
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(" 1) Insert \n 2) Reterive \n 3) Find by id \n 4) Delete \n 5) Exit");

		System.out.println("Enter the choice ...");
		int choice = Integer.parseInt(sc.nextLine());

		switch (choice) {
		case 1 -> {
			System.out.println("Enter the id ...");
			Long productId = Long.parseLong(sc.nextLine());

			System.out.println("Enter the productName ...");
			String productName = sc.nextLine();

			System.out.println("Enter the description ...");
			String description = sc.nextLine();

			System.out.println("Enter the price ...");
			Double price = Double.parseDouble(sc.nextLine());

			Product p = new Product(productId, productName, description, price);
			cont.insertProduct(p);
		}
		}
	}

}
