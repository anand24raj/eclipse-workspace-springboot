package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Book;

public interface BookService {

    Book saveBook(Book book);

    Page<Book> getAllBooks(int page, int size);

    Page<Book> searchBooks(String keyword, int page, int size);

    Book getBookById(Long id);

    Book updateBook(Book book);

    void deleteBook(Long id);
}