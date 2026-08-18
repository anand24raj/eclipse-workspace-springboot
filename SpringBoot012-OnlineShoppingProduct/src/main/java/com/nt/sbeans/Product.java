package com.nt.sbeans;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
@ConfigurationProperties(prefix = "product")
public class Product {

    private Integer productId;
    private String productName;
    private Double productPrice;
    private String productBrand;
    private Boolean stockAvailable;

    private List<String> colors;

    private Map<String,Integer> branchStock;

    // Getters and Setters
}