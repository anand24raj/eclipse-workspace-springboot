package com.nt.runner;

import com.nt.service.ProductService;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.nt.controller.ProductController;
import com.nt.entity.Product;

@Component

public class ConsoleApplicationRunner implements CommandLineRunner
{	
	private final ProductService productService;
	Scanner sc=new Scanner(System.in);
	 @Autowired
	 ProductController cont;
	 ConsoleApplicationRunner(ProductService productService) {
		this.productService = productService;
	 }
	@Override
	public void run(String... args) throws Exception {
	
		System.out.println(" 1) Insert \n 2) Reterive \n 3) Find by id \n 4) Delete \n 5) Exit");
			
		  System.out.println("Enter the choice ...");
	      int choice=Integer.parseInt(sc.nextLine());
	      
	      switch(choice)
	      {
	      case 1->
	      {
	    	    System.out.println("Enter the id ...");
	    	    Long productId=Long.parseLong(sc.nextLine());
	    	    
	    	    System.out.println("Enter the productName ...");
	    	    String productName=sc.nextLine();
	    	    
	    	    System.out.println("Enter the description ...");
	    	    String description=sc.nextLine();
	    	    
	    	    System.out.println("Enter the price ...");
	    	    Double price=Double.parseDouble(sc.nextLine());
	    	    
	    	    
	    	  Product p=new Product(productId, productName, description, price);
	    	  cont.insertProduct(p);
	      }
	      }
	}

}
