package com.nt.exception;

public class BookNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(Long id) {
        super("Book not found with ID: " + id);
    }
}
