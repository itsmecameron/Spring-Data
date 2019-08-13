package com.springdata.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springdata.mvc.models.Book;
import com.springdata.mvc.repositories.BookRepository;

@Service
public class BookService {
	// variable to call all methods in repository
	// adding the book repository as a dependency
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll(); // returns to BookRepository.java for List<book> findAll();
	}

	// creates a book and is also a method to use to update a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id); // Optional means that it could exist or not
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		// TODO Auto-generated method stub
		Book updateBook = bookRepository.findById(id).get();
		updateBook.setTitle(title);
		updateBook.setDescription(desc);
		updateBook.setLanguage(lang);
		updateBook.setNumberOfPages(numOfPages);

		bookRepository.save(updateBook);
		return updateBook;
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
