package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.nt.entity.Product;
import com.nt.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService 
{
    @Autowired
    private ProductRepository repo;

    @Override
    public Product addProduct(Product prod) 
    {
        return repo.save(prod);
    }

    @Override
    public Page<Product> getProductsByPage(int pageNo, int pageSize) 
    {
        return repo.findAll(PageRequest.of(pageNo, pageSize));
    }

    @Override
    public Iterable<Product> getProductsByPageAndPriceSorting(Boolean flag) 
    {
        Sort dir = Sort.by(flag ? Sort.Direction.ASC : Sort.Direction.DESC, "price");
        return repo.findAll(dir);
    }

    @Override
    public Optional<Product> searchProductById(Long id) {
        return repo.findById(id);
    }
}