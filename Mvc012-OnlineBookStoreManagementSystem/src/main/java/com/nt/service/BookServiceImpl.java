package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.Book;
import com.nt.repo.BookRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	private final BookRepository repo;

	public BookServiceImpl(BookRepository repo) {
		this.repo = repo;
	}

	@Override
	public Book saveBook(Book book) {
		book.setId(null);
		book.setDeleted(false);
		return repo.save(book);
	}

	@Override
	public List<Book> getActiveBooks() {
		return repo.findByDeletedFalse();
	}

	@Override
	public List<Book> getDeletedBooks() {
		return repo.findByDeletedTrue();
	}

	@Override
	public Book getBookById(Long id) {

		return repo.findById(id).filter(book -> !book.isDeleted())
				.orElseThrow(() -> new IllegalArgumentException("Active book not found with ID : " + id));
	}

	@Override
	public Book updateBook(Book book) {

		Book existingBook = getBookById(book.getId());

		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setCategory(book.getCategory());
		existingBook.setPrice(book.getPrice());
		existingBook.setPublisher(book.getPublisher());
		existingBook.setPublishedDate(book.getPublishedDate());
		existingBook.setStockQuantity(book.getStockQuantity());

		return repo.save(existingBook);
	}

	@Override
	public void deleteBook(Long id) {

		if (!repo.existsById(id)) {
			throw new IllegalArgumentException("Book not found with ID : " + id);
		}

		// Executes @SQLDelete
		repo.deleteById(id);
	}

	@Override
	public void restoreBook(Long id) {

		Book book = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found with ID : " + id));

		book.setDeleted(false);

		repo.save(book);
	}

	@Override
	public void permanentDelete(Long id) {

		if (!repo.existsById(id)) {
			throw new IllegalArgumentException("Book not found with ID : " + id);
		}

		repo.permanentDelete(id);
	}

}