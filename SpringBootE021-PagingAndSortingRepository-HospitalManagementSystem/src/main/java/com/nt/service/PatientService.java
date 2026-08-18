package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.Patient;

@Service
public interface PatientService 
{
	Iterable<Patient> addSinglePatient(List<Patient> pat);
	void getPatientsByPage(int pageNumber, int pageSize);
}
