package com.nt.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.RentalBook;
import com.nt.service.RentalBookServiceImpl;


@Component
public class RentalBookRunner implements CommandLineRunner {

	@Autowired
	private RentalBookServiceImpl service;

	@Override
	public void run(String... args) throws Exception {

		while (true) {

			IO.println("\n===== RENTAL BOOK MANAGEMENT SYSTEM =====");
			IO.println("1. Save Book");
			IO.println("2. Save Multiple Books");
			IO.println("3. Get Book By Id");
			IO.println("4. Get All Books");
			IO.println("5. Update Rental Price");
			IO.println("6. Delete Book By Id");
			IO.println("7. Delete All Books");
			IO.println("8. Count Books");
			IO.println("9. Check Book Exists");
			IO.println("10. Exit");

			int choice = Integer.parseInt(IO.readln("Enter Choice : "));

			switch (choice) {

			case 1 -> {

				String title = IO.readln("Enter Book Title : ");
				String author = IO.readln("Enter Author Name : ");
				String category = IO.readln("Enter Category : ");
				Double rentalPrice = Double.parseDouble(IO.readln("Enter Rental Price : "));

				RentalBook book = new RentalBook();
				book.setBookTitle(title);
				book.setAuthorName(author);
				book.setCategory(category);
				book.setRentalPrice(rentalPrice);

				IO.println("Book Saved Successfully...");
				IO.println(service.saveBook(book));
			}

			case 2 -> {

				int count = Integer.parseInt(IO.readln("How Many Books Do You Want To Insert? "));

				List<RentalBook> books = new ArrayList<>();

				for (int i = 1; i <= count; i++) {

					IO.println("\nEnter Details Of Book " + i);

					String title = IO.readln("Enter Book Title : ");
					String author = IO.readln("Enter Author Name : ");
					String category = IO.readln("Enter Category : ");
					Double rentalPrice = Double.parseDouble(IO.readln("Enter Rental Price : "));

					RentalBook book = new RentalBook();
					book.setBookTitle(title);
					book.setAuthorName(author);
					book.setCategory(category);
					book.setRentalPrice(rentalPrice);

					books.add(book);
				}

				service.saveAllBooks(books);
				IO.println("All Books Saved Successfully...");
			}

			case 3 -> {

				Long id = Long.parseLong(IO.readln("Enter Book Id : "));

				Optional<RentalBook> opt = service.getBookById(id);

				if (opt.isPresent())
					IO.println(opt.get());
				else
					IO.println("Book Not Found...");
			}

			case 4 -> {

				IO.println("\n===== ALL RENTAL BOOKS =====");

				service.getAllBooks().forEach(IO::println);
			}

			case 5 -> {

				Long id = Long.parseLong(IO.readln("Enter Book Id : "));
				Double price = Double.parseDouble(IO.readln("Enter New Rental Price : "));

				RentalBook book = new RentalBook();
				book.setBookId(id);
				book.setRentalPrice(price);

				try {
					IO.println("Updated Successfully...");
					IO.println(service.updateBook(book));
				}
				catch (Exception e) {
					IO.println(e.getMessage());
				}
			}

			case 6 -> {

				Long id = Long.parseLong(IO.readln("Enter Book Id : "));
				service.deleteBookById(id);
			}

			case 7 -> {

				service.deleteAllBooks();
			}

			case 8 -> {

				IO.println("Total Books : " + service.countBooks());
			}

			case 9 -> {

				Long id = Long.parseLong(IO.readln("Enter Book Id : "));

				if (service.existsBook(id))
					IO.println("Book Exists...");
				else
					IO.println("Book Does Not Exist...");
			}

			case 10 -> {

				IO.println("Application Closed Successfully...");
				System.exit(0);
			}

			default -> IO.println("Invalid Choice... Please Try Again.");
			}
		}
	}
}