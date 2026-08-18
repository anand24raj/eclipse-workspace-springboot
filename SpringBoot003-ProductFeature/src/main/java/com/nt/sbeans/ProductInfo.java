package com.nt.sbeans;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "product")
public class ProductInfo 
{
	private Integer id;
	private String name;
	private Map<String,String> features;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getFeatures() {
		return features;
	}
	public void setFeatures(Map<String, String> features) {
		this.features = features;
	}
	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", name=" + name + ", features=" + features + "]";
	}

}
