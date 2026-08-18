package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeController {

	@GetMapping("/prime/{number}")
	public String checkPrime(@PathVariable int number) {

		if (number < 2) {
			return number + " is Not a Prime Number";
		}

		for (int i = 2; i <= Math.sqrt(number); i++) {

			if (number % i == 0) {
				return number + " is Not a Prime Number";
			}
		}

		return number + " is a Prime Number";
	}
}