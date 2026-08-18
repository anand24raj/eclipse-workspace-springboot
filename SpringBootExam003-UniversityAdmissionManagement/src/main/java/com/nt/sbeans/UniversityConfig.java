package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix="university")
public class UniversityConfig 
{
    private int id;
    private String name;
    private String location;
    private double admissionFee;
    private long contact;
    private String website;
}
