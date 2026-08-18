package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String employeeName;
    private String department;
    private Double salary;
}