package com.nt.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "book53")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "Title is required")
	@Column(nullable = false)
	private String title;

	@NotEmpty(message = "Author is required")
	@Column(nullable = false)
	private String author;

	@NotEmpty(message = "Category is required")
	private String category;

	@NotNull(message = "Price is required")
	@Min(value = 1, message = "Price must be greater than 0")
	private BigDecimal price;

	@NotEmpty(message = "Publisher is required")
	private String publisher;

	@NotNull(message = "Published date is required")
	@Column(name = "published_date")
	private LocalDate publishedDate;

	@NotNull(message = "Stock quantity is required")
	@Min(value = 0, message = "Stock cannot be negative")
	@Column(name = "stock_quantity")
	private Integer stockQuantity;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

}