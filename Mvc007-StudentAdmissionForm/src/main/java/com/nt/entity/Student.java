package com.nt.entity;

import lombok.Data;

@Data
public class Student {

	private Long studentId;
	private String studentName;
	private String course;
	private Long mobileNo;
}