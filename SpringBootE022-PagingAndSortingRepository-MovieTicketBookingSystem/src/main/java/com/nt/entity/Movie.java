package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long movieId;

	@NonNull
	private String movieName;

	@NonNull
	private String language;

	@NonNull
	@Column(columnDefinition = "Number(10,2)")
	private Double ticketPrice;
}