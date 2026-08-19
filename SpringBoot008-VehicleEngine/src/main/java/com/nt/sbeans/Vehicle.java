package com.nt.sbeans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Vehicle implements CommandLineRunner{

	private final Engine engine;

	Vehicle(Engine engine) {
		this.engine = engine;
	}

	@Override
	public void run(String... args) throws Exception {
		engine.startEngine();
		engine.showEngineDetails();
	}

}