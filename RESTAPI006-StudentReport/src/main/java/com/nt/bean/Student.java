package com.nt.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Student {
	Integer id;
	String name;
}
