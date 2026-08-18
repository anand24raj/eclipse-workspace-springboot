package com.nt.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;

import com.nt.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, CrudRepository<Product, Long> 
{

}
