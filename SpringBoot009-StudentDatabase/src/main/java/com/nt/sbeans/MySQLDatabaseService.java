package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;



@Component
@Profile("mysql")
public class MySQLDatabaseService implements StudentDatabaseService
{
	@Value("${databaseUrl}")
	private String databaseUrl;
	
	@Value("${username}")
	private String username;
	
	@Value("${databaseName}")
	private String databaseName;


	@Override
	public void connectDatabase() 
	{
		System.out.println("Connect MySQL Database Service...");
	}


	@Override
	public void displayDatabaseInfo() 
	{
		System.out.println("Database Url : " + databaseUrl);
		System.out.println("Username : " + username);
		System.out.println("Database Name : " + databaseName);
	}

}
