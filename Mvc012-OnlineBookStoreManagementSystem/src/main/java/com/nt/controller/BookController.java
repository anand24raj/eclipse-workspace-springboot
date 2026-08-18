package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Book;
import com.nt.service.BookService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {

	private final BookService service;

	public BookController(BookService service) {
		this.service = service;
	}

	// =========================
	// Display Active Books
	// =========================
	@GetMapping({ "", "/", "/list" })
	public String showBookList(Model model) {

		model.addAttribute("books", service.getActiveBooks());

		return "book-list";
	}

	// =========================
	// Display Add Form
	// =========================
	@GetMapping("/add")
	public String showAddForm(Model model) {

		model.addAttribute("book", new Book());
		model.addAttribute("formTitle", "Add New Book");
		model.addAttribute("formAction", "/book/save");

		return "book-form";
	}

	// =========================
	// Save Book
	// =========================
	@PostMapping("/save")
	public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {

			model.addAttribute("formTitle", "Add New Book");
			model.addAttribute("formAction", "/book/save");

			return "book-form";
		}

		service.saveBook(book);

		redirectAttributes.addFlashAttribute("successMessage", "Book added successfully.");

		return "redirect:/book/list";
	}

	// =========================
	// Display Edit Form
	// =========================
	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {

		try {

			model.addAttribute("book", service.getBookById(id));
			model.addAttribute("formTitle", "Update Book");
			model.addAttribute("formAction", "/book/update");

			return "book-form";

		} catch (IllegalArgumentException ex) {

			redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());

			return "redirect:/book/list";
		}
	}

	// =========================
	// Update Book
	// =========================
	@PostMapping("/update")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {

			model.addAttribute("formTitle", "Update Book");
			model.addAttribute("formAction", "/book/update");

			return "book-form";
		}

		try {

			service.updateBook(book);

			redirectAttributes.addFlashAttribute("successMessage", "Book updated successfully.");

		} catch (IllegalArgumentException ex) {

			redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
		}

		return "redirect:/book/list";
	}

	// =========================
	// Soft Delete
	// =========================
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {

		try {

			service.deleteBook(id);

			redirectAttributes.addFlashAttribute("successMessage", "Book moved to Trash.");

		} catch (IllegalArgumentException ex) {

			redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
		}

		return "redirect:/book/list";
	}

	// =========================
	// Trash Page
	// =========================
	@GetMapping("/trash")
	public String showTrash(Model model) {

		model.addAttribute("books", service.getDeletedBooks());

		return "trash-books";
	}

	// =========================
	// Restore Book
	// =========================
	@GetMapping("/restore/{id}")
	public String restoreBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {

		try {

			service.restoreBook(id);

			redirectAttributes.addFlashAttribute("successMessage", "Book restored successfully.");

		} catch (IllegalArgumentException ex) {

			redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
		}

		return "redirect:/book/trash";
	}

	// =========================
	// Permanent Delete
	// =========================
	@GetMapping("/permanent-delete/{id}")
	public String permanentDelete(@PathVariable Long id, RedirectAttributes redirectAttributes) {

		try {

			service.permanentDelete(id);

			redirectAttributes.addFlashAttribute("successMessage", "Book permanently deleted.");

		} catch (IllegalArgumentException ex) {

			redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
		}

		return "redirect:/book/trash";
	}

}