package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ArchiveDocumentService;

@Component
public class ArchiveDocumentRunner implements CommandLineRunner {

	private final ArchiveDocumentService service;

	ArchiveDocumentRunner(ArchiveDocumentService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			IO.println("\n========== Digital Archive System ==========");
			IO.println("1. Save Document");
			IO.println("2. Retrieve Document By ID");
			IO.println("3. Update Binary File");
			IO.println("4. Delete Document");
			IO.println("5. Display All Metadata");
			IO.println("6. Display Metadata By ID");
			IO.println("7. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Your Choice : "));

			switch (choice) {

			case 1 -> {
				String title = IO.readln("Enter Document Title : ");
				String owner = IO.readln("Enter Owner Name : ");
				String filePath = IO.readln("Enter File Path : ");

				String result = service.saveDocument(title, owner, filePath);
				IO.println(result);
			}

			case 2 -> {
				Long id = Long.parseLong(IO.readln("Enter Document ID : "));
				String outputPath = IO.readln("Enter Output File Path : ");

				String result = service.retrieveDocument(id, outputPath);
				IO.println(result);
			}

			case 3 -> {
				Long id = Long.parseLong(IO.readln("Enter Document ID : "));
				String newFilePath = IO.readln("Enter New File Path : ");

				String result = service.updateDocument(id, newFilePath);
				IO.println(result);
			}

			case 4 -> {
				Long id = Long.parseLong(IO.readln("Enter Document ID : "));
				service.deleteDocument(id);
			}

			case 5 -> {
				service.displayAllMetadata();
			}

			case 6 -> {
				Long id = Long.parseLong(IO.readln("Enter Document ID : "));
				service.displayMetadataById(id);
			}

			case 7 -> {
				IO.println("Application Closed Successfully");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}
	}
}