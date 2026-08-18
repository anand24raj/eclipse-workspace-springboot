package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sbeans.NotificationService;

@Component

public class NotificationRunner implements CommandLineRunner
{
	@Autowired
	NotificationService ns;

	@Override
	public void run(String... args) throws Exception 
	{
		ns.sendNotification();
		ns.displayNotificationInfo();
	}

}
