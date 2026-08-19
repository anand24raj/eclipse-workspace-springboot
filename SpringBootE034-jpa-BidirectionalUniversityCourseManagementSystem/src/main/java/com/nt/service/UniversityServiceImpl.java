package com.nt.service;

import org.springframework.stereotype.Service;

import com.nt.entity.University;
import com.nt.repository.IUniversityRepository;

@Service
public class UniversityServiceImpl implements IUniversityService {

	final IUniversityRepository repo;

	UniversityServiceImpl(IUniversityRepository repo) {
		this.repo = repo;
	}

	@Override
	public void addUnivCourse(University university) {
		University save = repo.save(university);
		System.out.println(" university save succesfully.." + save);
	}

}
