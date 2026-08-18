package com.nt.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.ArchiveDocument;
import com.nt.repository.ArchiveDocumentRepository;

@Service
public class ArchiveDocumentServiceImpl implements ArchiveDocumentService {

	@Autowired
	private ArchiveDocumentRepository repo;

	@Override
	public String saveDocument(String title, String owner, String filePath) {

		try {
			File file = new File(filePath);

			if (!file.exists()) {
				return "File Not Found";
			}

			byte[] data = new byte[(int) file.length()];

			FileInputStream fis = new FileInputStream(file);
			fis.read(data);
			fis.close();

			String fileType = getFileExtension(file.getName());

			ArchiveDocument document = new ArchiveDocument();
			document.setDocumentTitle(title);
			document.setOwnerName(owner);
			document.setFileType(fileType);
			document.setDocumentData(data);

			repo.save(document);

			return "Document Saved Successfully";

		} catch (Exception e) {
			return "Error while saving document : " + e.getMessage();
		}
	}

	@Override
	public String retrieveDocument(Long id, String outputPath) {

		try {
			ArchiveDocument document = repo.findById(id).orElse(null);

			if (document == null) {
				return "Document ID Not Found";
			}

			FileOutputStream fos = new FileOutputStream(outputPath);
			fos.write(document.getDocumentData());
			fos.close();

			return "Document Retrieved and Written Successfully at : " + outputPath;

		} catch (Exception e) {
			return "Error while retrieving document : " + e.getMessage();
		}
	}

	@Override
	public String updateDocument(Long id, String newFilePath) {

		try {
			ArchiveDocument document = repo.findById(id).orElse(null);

			if (document == null) {
				return "Document ID Not Found";
			}

			File file = new File(newFilePath);

			if (!file.exists()) {
				return "New File Not Found";
			}

			byte[] data = new byte[(int) file.length()];

			FileInputStream fis = new FileInputStream(file);
			fis.read(data);
			fis.close();

			document.setDocumentData(data);
			document.setFileType(getFileExtension(file.getName()));

			repo.save(document);

			return "Document Updated Successfully";

		} catch (Exception e) {
			return "Error while updating document : " + e.getMessage();
		}
	}

	@Override
	public void deleteDocument(Long id) {

		if (repo.existsById(id)) {
			repo.deleteById(id);
			IO.println("Document Deleted Successfully");
		} else {
			IO.println("Document ID Not Found");
		}
	}

	@Override
	public void displayAllMetadata() {

		if (repo.findAll().isEmpty()) {
			IO.println("No Documents Found");
		} else {
			repo.findAll().forEach(doc -> {
				IO.println("--------------------------------");
				IO.println("Document ID    : " + doc.getDocumentId());
				IO.println("Document Title : " + doc.getDocumentTitle());
				IO.println("Owner Name     : " + doc.getOwnerName());
				IO.println("File Type      : " + doc.getFileType());
				IO.println("File Size      : " + doc.getDocumentData().length + " bytes");
				IO.println("--------------------------------");
			});
		}
	}

	@Override
	public void displayMetadataById(Long id) {

		ArchiveDocument doc = repo.findById(id).orElse(null);

		if (doc != null) {
			IO.println("--------------------------------");
			IO.println("Document ID    : " + doc.getDocumentId());
			IO.println("Document Title : " + doc.getDocumentTitle());
			IO.println("Owner Name     : " + doc.getOwnerName());
			IO.println("File Type      : " + doc.getFileType());
			IO.println("File Size      : " + doc.getDocumentData().length + " bytes");
			IO.println("--------------------------------");
		} else {
			IO.println("Document ID Not Found");
		}
	}

	private String getFileExtension(String fileName) {

		int index = fileName.lastIndexOf(".");

		if (index > 0) {
			return fileName.substring(index + 1);
		}

		return "unknown";
	}
}