package com.nt.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Book;
import com.nt.service.BookService;

@Component
public class BookRunner implements CommandLineRunner {

	@Autowired
	private BookService service;

	@Override
	public void run(String... args) throws Exception {

		// Initial Data
//		service.addBook(new Book("Core Java", "James Gosling", 550.0));
//		service.addBook(new Book("Spring Boot", "Craig Walls", 650.0));
//		service.addBook(new Book("Hibernate", "Gavin King", 500.0));
//		service.addBook(new Book("Oracle SQL", "Scott", 450.0));
//		service.addBook(new Book("Data Structures", "Narasimha Karumanchi", 700.0));

		while (true) {

			IO.println("\n===== LIBRARY BOOK MANAGEMENT SYSTEM =====");
			IO.println("1. Add New Book");
			IO.println("2. View All Books");
			IO.println("3. Search Book By Id");
			IO.println("4. Update Book Price");
			IO.println("5. Delete Book");
			IO.println("6. Check Book Availability");
			IO.println("7. Count Total Books");
			IO.println("8. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Choice : "));

			switch (choice) {

			case 1 -> {

				String bookName = IO.readln("Enter Book Name : ");
				String authorName = IO.readln("Enter Author Name : ");
				Double price = Double.parseDouble(IO.readln("Enter Price : "));

				Book book = new Book(bookName, authorName, price);

				IO.println("Book Added Successfully");
				IO.println(service.addBook(book));
			}

			case 2 -> {

				IO.println("\n===== ALL BOOKS =====");

				service.viewAllBooks().forEach(IO::println);
			}

			case 3 -> {

				Long id = Long.parseLong(IO.readln("Enter Book Id : "));

				Optional<Book> opt = service.searchBookById(id);

				if (opt.isPresent())
					IO.println(opt.get());
				else
					IO.println("Book Not Found");
			}

			case 4 -> {

				Long id = Long.parseLong(IO.readln("Enter Book Id : "));
				Double newPrice = Double.parseDouble(IO.readln("Enter New Price : "));

				Book book = service.updateBookPrice(id, newPrice);

				if (book != null)
					IO.println("Updated Successfully : " + book);
				else
					IO.println("Book Not Found");
			}

			case 5 -> {

				Long id = Long.parseLong(IO.readln("Enter Book Id : "));

				service.deleteBookbyId(id);
			}

			case 6 -> {

				Long id = Long.parseLong(IO.readln("Enter Book Id : "));

				boolean status = service.checkBookAvailability(id);

				if (status)
					IO.println("Book Available");
				else
					IO.println("Book Not Available");
			}

			case 7 -> {

				IO.println("Total Books : " + service.countTotalBooks());
			}

			case 8 -> {

				IO.println("Application Closed...");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice");
			}
		}
	}
}