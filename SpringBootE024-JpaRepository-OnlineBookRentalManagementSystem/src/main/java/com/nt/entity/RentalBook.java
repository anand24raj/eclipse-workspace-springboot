package com.nt.entity;

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
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class RentalBook {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	@NonNull
	private String bookTitle;
	@NonNull
	private String authorName;
	@NonNull
	private String category;
	@NonNull
	private Double rentalPrice;
}
