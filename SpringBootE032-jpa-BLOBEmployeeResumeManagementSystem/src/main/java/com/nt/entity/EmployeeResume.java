package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResume {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	@Column(length = 20)
	private String employeeName;

	@Column(length = 20)
	private String designation;

	@Lob
	@Column(columnDefinition = "CLOB")
	private String resumeContent;
	
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] pic;

}
