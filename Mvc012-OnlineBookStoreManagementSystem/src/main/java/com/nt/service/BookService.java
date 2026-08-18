package com.nt.service;

import java.util.List;

import com.nt.entity.Book;

public interface BookService {

	// Save new book
	Book saveBook(Book book);

	// Update existing book
	Book updateBook(Book book);

	// Get all active books (deleted = false)
	List<Book> getActiveBooks();

	// Get active book by ID
	Book getBookById(Long id);

	// Soft delete
	void deleteBook(Long id);

	// Get deleted books (Trash)
	List<Book> getDeletedBooks();

	// Restore deleted book
	void restoreBook(Long id);

	// Permanently delete
	void permanentDelete(Long id);

}