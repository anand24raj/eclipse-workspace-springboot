package com.nt.sbean;

import java.util.*;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Data
@Component
@ConfigurationProperties(prefix = "student")
public class Student {

	int id;
	String name;
	String course;
	double fee;
	String institue;
	
	List<String> subjects;
	
	Map<String,Double> marks;

}
