package com.nt.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book53")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150)
	private String title;

	@Column(nullable = false, length = 100)
	private String author;

	@Column(nullable = false, length = 100)
	private String category;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;

	@Column(length = 150)
	private String publisher;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "published_date", nullable = false)
	private LocalDate publishedDate;

	@Column(name = "stock_quantity", nullable = false)
	private Integer stockQuantity;

	@Column(nullable = false)
	private boolean deleted = false;
}