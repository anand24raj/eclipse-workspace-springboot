package com.nt.service;

import org.springframework.stereotype.Service;

import com.nt.entity.EmployeeResume;
import com.nt.repository.EmployeeResumeRepository;

@Service
public class EmployeeResumeSeviceImpl  implements EmployeeResumeSevice{

	final EmployeeResumeRepository repo;

	EmployeeResumeSeviceImpl(EmployeeResumeRepository repo) {
		this.repo = repo;
	}
	
	
	@Override
	public String saveEmployeeResume(EmployeeResume eRes) {
		EmployeeResume saved = repo.save(eRes);
		return saved != null ? "Employee Resume Saved Successfully" : "Employee Resume Not Saved";
	}

	@Override
	public Iterable<EmployeeResume> viewAllEmployeeResumes() {
		return repo.findAll();
	}

	@Override
	public EmployeeResume viewEmployeeResumebyId(Long eId) {
		return repo.findById(eId).orElse(null);
	}

	@Override
	public void deleteEmployeeResume(Long eId) {
		if (repo.existsById(eId)) {
			repo.deleteById(eId);
			IO.println("Employee Resume Deleted Successfully");
		} else {
			IO.println("Employee Resume ID Not Found");
		}
		
	}		
}
