package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
