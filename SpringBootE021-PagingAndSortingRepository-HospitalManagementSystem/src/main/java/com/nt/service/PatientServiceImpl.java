package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nt.entity.Patient;
import com.nt.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	private final PatientRepository repo;

	PatientServiceImpl(PatientRepository repo) {
        this.repo = repo;
    }

    @Override
    public Iterable<Patient> addSinglePatient(List<Patient> pat) {
        return repo.saveAll(pat);
    }

    @Override
    public void getPatientsByPage(int pageNumber, int pageSize) {

        Page<Patient> page = repo.findAll(PageRequest.of(pageNumber, pageSize));

        System.out.println("\n===== Patient Details =====");

        page.getContent().forEach(System.out::println);

        System.out.println("Current Page : " + (page.getNumber() + 1));
        System.out.println("Total Pages  : " + page.getTotalPages());
        System.out.println("Total Records: " + page.getTotalElements());
    }
}