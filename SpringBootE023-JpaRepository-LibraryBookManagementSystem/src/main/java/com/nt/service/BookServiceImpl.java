package com.nt.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nt.entity.Book;
import com.nt.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	final BookRepository repo;

	BookServiceImpl(BookRepository repo) {
		this.repo = repo;
	}

	@Override
	public Book addBook(Book book) {
		return repo.save(book);
	}

	@Override
	public Iterable<Book> viewAllBooks() {
		return repo.findAll();
	}

	@Override
	public Optional<Book> searchBookById(Long id) {
		return repo.findById(id);
	}

	@Override
	public Book updateBookPrice(Long id, Double newPrice) {
		Optional<Book> opt = repo.findById(id);

		if (opt.isPresent()) {
			Book book = opt.get();
			book.setPrice(newPrice);
			return repo.save(book);
		}

		return null;
//		Book b=new Book();
//		      boolean existsById = repo.existsById(id);
//		        if(existsById)
//		        {
//		        	   b.setPrice(newPrice);
//		        	   System.out.println("New price set ");
//		        }
//		        
//		        return b;
//		Optional<Book> opt = repo.findById(id);
//
//		if (opt.isPresent()) {
//			Book book = opt.get();
//			book.setPrice(newPrice);
//			return repo.save(book);
//		}
//
//		return null;

	}

	@Override
	public void deleteBookbyId(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			IO.println("Delete ID Successfully " + id);
		}
		IO.println(id + " Not found ");
	}

	@Override
	public boolean checkBookAvailability(Long id) {
		return repo.existsById(id);
	}

	@Override
	public long countTotalBooks() {
		return repo.count();
	}

}
