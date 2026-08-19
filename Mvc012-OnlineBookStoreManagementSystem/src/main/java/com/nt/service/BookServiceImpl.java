package com.nt.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Book;
import com.nt.exception.BookNotFoundException;
import com.nt.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Page<Book> getAllBooks(int page, int size) {

		Pageable pageable = PageRequest.of(page, size, Sort.by(Book::getId).descending());

		return bookRepository.findAll(pageable);
	}

	@Override
	public Page<Book> searchBooks(String keyword, int page, int size) {

		Pageable pageable = PageRequest.of(page, size, Sort.by(Book::getId).descending());

		if (keyword == null || keyword.trim().isEmpty()) {
			return bookRepository.findAll(pageable);
		}

		return bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrCategoryContainingIgnoreCase(
				keyword, keyword, keyword, pageable);
	}

	@Override
	public Book getBookById(Long id) {

		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
	}

	@Override
	public Book updateBook(Book book) {

		if (book.getId() == null || !bookRepository.existsById(book.getId())) {
			throw new BookNotFoundException(book.getId());
		}

		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {

		if (!bookRepository.existsById(id)) {
			throw new BookNotFoundException(id);
		}

		bookRepository.deleteById(id);
	}
}