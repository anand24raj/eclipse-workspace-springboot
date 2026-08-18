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

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Book 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookId;
	@NonNull
	private String bookName;
	@NonNull
	private String authorName;
	@NonNull
	@Column(columnDefinition = "Number(10,2)")
	private Double price;
}
