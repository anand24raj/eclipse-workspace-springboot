package com.nt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRIME-SERVICE")
public interface PrimeFeignClient {

	@GetMapping("/prime/{number}")
	String checkPrime(@PathVariable int number);
}
