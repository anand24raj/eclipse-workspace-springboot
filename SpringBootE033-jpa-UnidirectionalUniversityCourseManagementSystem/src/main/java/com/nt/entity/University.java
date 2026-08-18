package com.nt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
@Table
@Getter
@Setter
@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "univ_seq")
	@SequenceGenerator(name = "univ_seq", sequenceName = "UNIV_SEQ", initialValue = 100, allocationSize  = 1)
	@Column(name = "UNIV_ID")
	
	private Long universityId;

	@NonNull
	@Column(length = 30)
	private String universityName;
	@NonNull
	@Column(length = 20)
	private String city;
	
	@OneToMany(targetEntity = Course.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "UNIV_ID",referencedColumnName ="UNIV_ID")
	private List<Course> courses;

}
