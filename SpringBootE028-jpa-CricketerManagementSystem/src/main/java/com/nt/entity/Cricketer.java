package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cricketers")

@NoArgsConstructor
@AllArgsConstructor

public class Cricketer {
	
	@Id
	private Long id;

	private String playerName;

	private String country;

	private String role;

	private String team;

	private Double battingAverage;

	private Integer matchesPlayed;

	private Integer centuries;

	private Integer age;

	private Boolean retired;

}
