package com.nt.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.Book;
import com.nt.service.BookService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	// Display all books
	@GetMapping("/list")
	public String listBooks(@RequestParam(defaultValue = "0") int page, Model model) {

		int pageSize = 10;

		Page<Book> bookPage = bookService.getAllBooks(page, pageSize);

		model.addAttribute("bookPage", bookPage);
		model.addAttribute("books", bookPage.getContent());
		model.addAttribute("keyword", "");

		return "book-list";
	}

	// Show add form
	@GetMapping("/new")
	public String showBookForm(Model model) {

		model.addAttribute("book", new Book());

		return "book-form";
	}

	// Save new book
	@PostMapping("/save")
	public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

		if (result.hasErrors()) {
			return "book-form";
		}

		bookService.saveBook(book);

		return "redirect:/book/list";
	}

	// Show edit form
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable Long id, Model model) {

		Book book = bookService.getBookById(id);

		model.addAttribute("book", book);

		return "book-form";
	}

	// Update book
	@PostMapping("/update")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {

		if (result.hasErrors()) {
			return "book-form";
		}

		bookService.updateBook(book);

		return "redirect:/book/list";
	}

	// Delete book
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id) {

		bookService.deleteBook(id);

		return "redirect:/book/list";
	}

	// Search
	@GetMapping("/search")
	public String searchBooks(@RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "0") int page, Model model) {

		int pageSize = 10;

		Page<Book> bookPage = bookService.searchBooks(keyword, page, pageSize);

		model.addAttribute("bookPage", bookPage);
		model.addAttribute("books", bookPage.getContent());
		model.addAttribute("keyword", keyword);

		return "book-list";
	}
}