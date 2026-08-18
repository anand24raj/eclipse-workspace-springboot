package com.nt.cont;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoggingController 
{	
	   @GetMapping("/home")
	   @ResponseBody
	   public String home() 
	   {
	   	return new String("Welcome to home page...");
	   }
}
