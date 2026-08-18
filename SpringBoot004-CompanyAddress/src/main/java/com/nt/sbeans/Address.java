package com.nt.sbeans;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class Address {

		private String city;
		private String state;
		private Integer pincode;

}
