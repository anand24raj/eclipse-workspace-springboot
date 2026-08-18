package com.nt.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Product;
import com.nt.service.ProductService;

@Component
public class ProductRunner implements CommandLineRunner 
{
    @Autowired
    private ProductService service;

    @Override
    public void run(String... args) throws Exception 
    {
        while (true) 
        {
            IO.println("\n===== E-COMMERCE PRODUCT CATALOG SYSTEM =====");
            IO.println("1. Add Product");
            IO.println("2. Display Products Page Wise");
            IO.println("3. Display Products Sorted By Price ASC");
            IO.println("4. Display Products Sorted By Price DESC");
            IO.println("5. Search Product By ID");
            IO.println("6. Exit");

            int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

            switch (choice) 
            {
            case 1 -> 
            {
                Product prod = new Product();

                prod.setProductName(IO.readln("Enter Product Name : "));
                prod.setCategory(IO.readln("Enter Category : "));
                prod.setBrand(IO.readln("Enter Brand : "));
                prod.setPrice(Double.parseDouble(IO.readln("Enter Price : ")));
                prod.setStockQuantity(Integer.parseInt(IO.readln("Enter Stock Quantity : ")));

                Product saved = service.addProduct(prod);

                IO.println("Product Added Successfully");
                IO.println(saved);
            }

            case 2 -> {
                int pageNo = Integer.parseInt(IO.readln("Enter Page Number : "));
                int pageSize = Integer.parseInt(IO.readln("Enter Page Size : "));

                Page<Product> page = service.getProductsByPage(pageNo, pageSize);

                page.forEach(IO::println);

            }

            case 3 -> service.getProductsByPageAndPriceSorting(true).forEach(IO::println);

            case 4 -> service.getProductsByPageAndPriceSorting(false).forEach(IO::println);


            case 5 -> {
                Long id = Long.parseLong(IO.readln("Enter Product ID : "));

                Optional<Product> prod = service.searchProductById(id);

                if (prod != null) 
                {
                    IO.println(prod);
                } 
                else 
                {
                    IO.println("Product Not Found");
                }
            }

            case 6 -> {
                IO.println("Application Closed Successfully");
                System.exit(0);
            }

            default -> IO.println("Invalid Choice");
            }
        }
    }
}