package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@Table(name = "EMPLOYEES")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long employeeID;
	@NonNull
	private String employeeName;
	@NonNull
	private String department; 
	@NonNull
	private String designation;
	@NonNull
	private Double basicSalary;
	@NonNull
	private Double bonus;
	@NonNull
	private Double netSalary;
	@NonNull
	private Double experience;
	@NonNull
	private Character PerformanceRating;
	

}
