package com.nt.service;

import org.springframework.stereotype.Service;

import com.nt.entity.University;

@Service
public interface IUniversityService {
	public void addUnivCourse(University university);

}
