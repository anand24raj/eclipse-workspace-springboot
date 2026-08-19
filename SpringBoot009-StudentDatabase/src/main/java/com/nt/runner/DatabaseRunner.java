package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.StudentDatabaseService;

@Component
public class DatabaseRunner implements CommandLineRunner 
{
	private final StudentDatabaseService sds;

	DatabaseRunner(StudentDatabaseService sds) {
		this.sds = sds;
	}

	@Override
	public void run(String... args) throws Exception
	{
		sds.connectDatabase();
		sds.displayDatabaseInfo();
	}

}
