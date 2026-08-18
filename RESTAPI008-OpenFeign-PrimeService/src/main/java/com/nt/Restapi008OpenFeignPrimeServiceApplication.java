package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Restapi008OpenFeignPrimeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Restapi008OpenFeignPrimeServiceApplication.class, args);
	}

}
