package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bean.Student;


@RestController
public class StdController {
	
	List<Student> ll=new ArrayList<Student>();
	
	@PostMapping("/std")
	public String addStd(@RequestBody Student student) {
		System.out.println(student);
		ll.add(student);
		return "Student Added Succesfully...";
	}
	@GetMapping("/std")
	public List<Student> getAllStd(){
		return ll;
	}

}
