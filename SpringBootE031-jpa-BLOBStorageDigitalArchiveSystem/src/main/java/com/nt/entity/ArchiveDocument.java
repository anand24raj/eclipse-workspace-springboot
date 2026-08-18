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
@Table(name = "ARCHIVE_DOCUMENT")
@NoArgsConstructor
@AllArgsConstructor
public class ArchiveDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long documentId;

	@Column(length = 30)
	private String documentTitle;

	@Column(length = 20)
	private String ownerName;

	@Column(length = 10)
	private String fileType;

	@Lob
	private byte[] documentData;
}