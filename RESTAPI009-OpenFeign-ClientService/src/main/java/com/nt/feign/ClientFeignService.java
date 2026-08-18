package com.nt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "RESTAPI009-OpenFeign-MessageService")
public interface ClientFeignService {

	@GetMapping("/message")
	public String getMessage();
}
