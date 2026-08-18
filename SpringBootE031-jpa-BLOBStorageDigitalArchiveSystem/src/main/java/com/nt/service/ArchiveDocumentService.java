package com.nt.service;

public interface ArchiveDocumentService {

	String saveDocument(String title, String owner, String filePath);

	String retrieveDocument(Long id, String outputPath);

	String updateDocument(Long id, String newFilePath);

	void deleteDocument(Long id);

	void displayAllMetadata();

	void displayMetadataById(Long id);
}