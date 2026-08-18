package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nt.feign.PrimeFeignClient;

@RestController
public class NumberController {

	private final PrimeFeignClient primeFeignClient;

	NumberController(PrimeFeignClient primeFeignClient) {
		this.primeFeignClient = primeFeignClient;
	}

	@GetMapping("/number/{number}")
	public String checkNumber(@PathVariable int number) {

		return primeFeignClient.checkPrime(number);
	}
}
