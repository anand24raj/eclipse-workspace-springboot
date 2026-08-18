package com.nt.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    @NonNull
    private String productName;
    @NonNull
    private String category;
    @NonNull
    private String brand;
    @NonNull
    private Double price;
    @NonNull
    private Integer stockQuantity;
}