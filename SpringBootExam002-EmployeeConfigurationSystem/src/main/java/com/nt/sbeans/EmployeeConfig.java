package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "employee")
public class EmployeeConfig 
{
	int id;
	String name;
	String department;
	double salary;
	String designation;
}
