package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.StudentDatabaseService;

@Component
public class DatabaseRunner implements CommandLineRunner 
{
	@Autowired
	private StudentDatabaseService sds;

	@Override
	public void run(String... args) throws Exception
	{
		sds.connectDatabase();
		sds.displayDatabaseInfo();
	}

}
