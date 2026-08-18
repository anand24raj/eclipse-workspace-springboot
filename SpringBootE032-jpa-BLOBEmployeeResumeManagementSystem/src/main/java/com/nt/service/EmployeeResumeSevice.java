package com.nt.service;

import org.springframework.stereotype.Service;

import com.nt.entity.EmployeeResume;


@Service
public interface EmployeeResumeSevice {
	
	
	String saveEmployeeResume(EmployeeResume eRes);

	Iterable<EmployeeResume> viewAllEmployeeResumes();

	EmployeeResume viewEmployeeResumebyId(Long eId);

	void deleteEmployeeResume(Long eId);
}
