package com.nt.sbeans;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix="hospital")
public class HospitalInfo 
{
	private Integer id;
	private String name;
	private List<String> doctors;
	private String[] specialists;
	private Map<String,Integer> staff;

}
