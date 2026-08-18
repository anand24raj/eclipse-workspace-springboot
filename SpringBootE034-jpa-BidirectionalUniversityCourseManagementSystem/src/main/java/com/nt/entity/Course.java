package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Course")
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
	@SequenceGenerator(name = "course_seq", sequenceName = "COURSE_SEQ",initialValue = 101, allocationSize = 1)
	@Column(name = "COURSE_ID")
	private Long courseId;

	@Column(length = 30)
	private String courseName;
	
	@Column(length = 20)
	private String duration;
	
	@Column(length = 7)
	private Double fee;
	
	@ManyToOne
	@JoinColumn(name = "UNIV_ID")
	private University university;
	
}
