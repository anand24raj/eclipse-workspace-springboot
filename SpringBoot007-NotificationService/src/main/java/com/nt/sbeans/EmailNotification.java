package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Email")
public class EmailNotification implements NotificationService
{
	@Value("${senderName}")
	private String senderName;
	
	@Value("${supportEmail}")
	private String supportEmail;
	
	@Value("${notificationType}")
	private String notificationType;
	
	@Override
	public void sendNotification() {
		System.out.println("\nSend Notification to User by Email...");
		
	}
	@Override
	public void displayNotificationInfo() 
	{
		System.out.println("\n"+senderName);
		System.out.println(supportEmail);
		System.out.println(notificationType);
		
		
	}

}
