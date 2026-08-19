package com.nt.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.entity.Product;
import com.nt.repo.ProductRepository;

@Service
public class ProductService implements IProductService {

	final ProductRepository repo;

	ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public void insertProduct(Product product) {

        repo.save(product);

        System.out.println("Product inserted successfully...");
    }

    @Override
    public Iterable<Product> getAllProducts() {

        return repo.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {

        return repo.findById(id);
    }

    @Override
    public void deleteProductById(Long id) {

        repo.deleteById(id);

        System.out.println("Deleted successfully...");
    }
}