package com.nt.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.PatientServiceImpl;
@Component
public class PatientRunner implements CommandLineRunner {
	final PatientServiceImpl service;

	PatientRunner(PatientServiceImpl service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {
		
        service.getPatientsByPage(0, 3); // Page 1
        service.getPatientsByPage(1, 15); // Page 2
        service.getPatientsByPage(2, 15); // Page 3
	}

}
