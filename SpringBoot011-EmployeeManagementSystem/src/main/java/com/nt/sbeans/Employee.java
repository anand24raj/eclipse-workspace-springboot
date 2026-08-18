package com.nt.sbeans;

import java.util.*;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "employee")
public class Employee 
{
	 int empId;
	 String empName;
	 double empSalary;
	 String department;
	 String company;
	 List<String> skills;
	 Map<String, String> projectRatings; 

}
