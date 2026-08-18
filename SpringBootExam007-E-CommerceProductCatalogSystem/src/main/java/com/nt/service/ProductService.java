package com.nt.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.nt.entity.Product;

public interface ProductService 
{
    Product addProduct(Product prod);

    Page<Product> getProductsByPage(int pageNo, int pageSize);

    Iterable<Product> getProductsByPageAndPriceSorting(Boolean flag);
    
    Optional<Product> searchProductById(Long id);
}