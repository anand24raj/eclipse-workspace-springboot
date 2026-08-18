package com.nt.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.entity.Product;
import com.nt.service.IProductService;

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    public void insertProduct(Product product) {

        productService.insertProduct(product);
    }

    public void retrieveAllProducts() {

        Iterable<Product> products =
                productService.getAllProducts();

        System.out.println("-------------------------------------------------------------");

        System.out.printf("%-10s %-15s %-20s %-10s\n",
                "ID", "NAME", "DESCRIPTION", "PRICE");

        System.out.println("-------------------------------------------------------------");

        for(Product product : products) {

            System.out.printf("%-10d %-15s %-20s %-10.2f\n",
                    product.getProductId(),
                    product.getProductName(),
                    product.getDescription(),
                    product.getPrice());
        }

        System.out.println("-------------------------------------------------------------");
    }
    
    public void findProductById(Long id) {

        Optional<Product> optional =
                productService.findProductById(id);

        if(optional.isPresent()) {

            System.out.println(optional.get());

        } else {

            System.out.println("Product Not Found");
        }
    }

    public void deleteProductById(Long id) {

        productService.deleteProductById(id);
    }
}