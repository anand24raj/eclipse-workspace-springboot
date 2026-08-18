package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "STUDENT_INFO")
public class Student {
	
	@Id
	@Column(name = "STD_ID")
	 @SequenceGenerator(
	            name = "gen1",
	            sequenceName = "student_info_seq",
	            allocationSize = 1
	    )
	    @GeneratedValue(
	            generator = "gen1",
	            strategy = GenerationType.SEQUENCE
	    )
	Integer stdId;
	@NonNull
	@Column(name = "STD_NAME",length = 40)
	String stdName;
	@NonNull
	@Column(name = "STD_ADDRS",length = 70)
	String stdAddrs;

}
