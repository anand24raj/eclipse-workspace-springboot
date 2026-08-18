package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {

    @Id
    Long productId;

    String productName;
    String description;
    Double price;

    public Product() {

    }

    public Product(Long productId,
                   String productName,
                   String description,
                   Double price) {

        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}