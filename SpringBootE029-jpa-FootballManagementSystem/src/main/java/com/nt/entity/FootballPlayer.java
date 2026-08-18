package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "football")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FootballPlayer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long playerId;

	@Column(length = 25, nullable = false)
	private String playerName;

	@Column(length = 15, nullable = false)
	private String country;

	@Column(length = 20, nullable = false)
	private String club;

	@Column(length = 15, nullable = false)
	private String position;

	@Column(nullable = false)
	private Double salary;

	@Column(nullable = false)
	private Integer jerseyNumber;

	@Version
	private Integer version;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
