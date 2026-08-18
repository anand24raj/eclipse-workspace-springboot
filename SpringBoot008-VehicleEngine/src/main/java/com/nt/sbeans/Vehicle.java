package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Vehicle implements CommandLineRunner{

    @Autowired
    private Engine engine;

	@Override
	public void run(String... args) throws Exception {
		engine.startEngine();
		engine.showEngineDetails();
	}

}