package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.entity.RentalBook;

@Service
public interface RentalBookService {
	RentalBook saveBook(RentalBook book);

	Iterable<RentalBook> saveAllBooks(List<RentalBook> books);

	Optional<RentalBook> getBookById(Long id);

	Iterable<RentalBook> getAllBooks();

	RentalBook updateBook(RentalBook book)throws IllegalAccessException ;

	void deleteBookById(Long id);

	void deleteAllBooks();

	Long countBooks();

	Boolean existsBook(Long id);

}
