package com.nt.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.entity.Book;

@Service
public interface BookService 
{
	//	1. Add New Book
    Book addBook(Book book);

	//	2. View All Books -> fetch
    Iterable<Book> viewAllBooks();

          // 
	//	3. Search Book By Id
    Optional<Book> searchBookById(Long id);

    //   
	//	4. Update Book Price
    Book updateBookPrice(Long id, Double newPrice);

	//	5. Delete Book
    void deleteBookbyId(Long id);

	//	6. Check Book Availability
    boolean checkBookAvailability(Long id);

	//	7. Count Total Books
    long countTotalBooks();
}
