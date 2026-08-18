package com.nt.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("travel_package")
public class TravelPackage {

	@Id
	@Column("package_id")
	private Integer packageId;

	@NotBlank(message = "Package name is required")
	@Column("package_name")
	private String packageName;

	@NotBlank(message = "Destination is required")
	@Column("destination")
	private String destination;

	@NotNull(message = "Price is required")
	@Positive(message = "Price must be greater than zero")
	@Column("price")
	private Double price;

	@NotNull(message = "Duration is required")
	@Positive(message = "Duration must be greater than zero")
	@Column("duration")
	private Integer duration;

	public TravelPackage() {
	}

	public TravelPackage(Integer packageId, String packageName, String destination, Double price, Integer duration) {

		this.packageId = packageId;
		this.packageName = packageName;
		this.destination = destination;
		this.price = price;
		this.duration = duration;
	}

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}