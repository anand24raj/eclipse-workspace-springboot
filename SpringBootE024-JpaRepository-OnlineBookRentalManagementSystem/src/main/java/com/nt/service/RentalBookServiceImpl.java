package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.RentalBook;
import com.nt.repository.RentalBookRepository;

@Service
public class RentalBookServiceImpl implements RentalBookService {

	@Autowired
	RentalBookRepository repo;

	@Override
	public RentalBook saveBook(RentalBook book) {
		return repo.save(book);
	}

	@Override
	public Iterable<RentalBook> saveAllBooks(List<RentalBook> books) {
		return repo.saveAll(books);
	}

	@Override
	public Optional<RentalBook> getBookById(Long id) {
		return repo.findById(id);
	}

	@Override
	public Iterable<RentalBook> getAllBooks() {
		return repo.findAll();
	}

	@Override
	public RentalBook updateBook(RentalBook book) throws IllegalAccessException {
		Optional<RentalBook> byId = repo.findById(book.getBookId());
		if (byId.isPresent()) {
			RentalBook rentalBook = byId.get();
			rentalBook.setRentalPrice(book.getRentalPrice());
			return repo.save(rentalBook);
		}
		throw new IllegalAccessException("Invalid ID ");
	}

	@Override
	public void deleteBookById(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			IO.println("Id deleted Succesfully....");
		}

	}

	@Override
	public void deleteAllBooks() 
	{
		repo.deleteAll();
		IO.println("Id deleted Succesfully....");
	}

	@Override
	public Long countBooks() {
		return repo.count();
	}

	@Override
	public Boolean existsBook(Long id) {
		return repo.existsById(id);
	}

}
