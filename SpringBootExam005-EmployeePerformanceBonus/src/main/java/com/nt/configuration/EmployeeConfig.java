package com.nt.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "employee")
public class EmployeeConfig {

    private int id;
    private String name;
    private double salary;
    private double rating;
    private int experience;
}
