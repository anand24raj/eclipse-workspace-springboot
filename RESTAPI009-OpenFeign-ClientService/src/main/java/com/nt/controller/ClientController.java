package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.feign.ClientFeignService;

@RestController
public class ClientController {

	final ClientFeignService clientFeignService;

	ClientController(ClientFeignService clientFeignService) {
		this.clientFeignService = clientFeignService;
	}
	
	@GetMapping("/get")
	public String message()
	{
		return clientFeignService.getMessage();
	}

}
