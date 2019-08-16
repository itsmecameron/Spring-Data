package com.springdata.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springdata.mvc.models.Book;
import com.springdata.mvc.services.BookService;

@Controller
public class BooksController {
//    private final BookService bookService;
    @Autowired
    BookService bookService;
    
    @GetMapping("/")
    public String home(Model model) {
    	List<Book> allbooks = bookService.allBooks();
    	model.addAttribute("books", allbooks);
    	return "books/index.jsp";
    }
    
    @GetMapping("/createNewBook")
    public String newBook(Model model) {
    	model.addAttribute("newBookObject", new Book());
    	return "books/new.jsp";
    }
    
    @PostMapping("/books")
    public String createBook (@Valid @ModelAttribute("newBookObject") Book book, BindingResult results) {
		if(results.hasErrors()) {
			return "books/new.jsp";
		}
		bookService.createOrUpdateBook(book);
		return "redirect:/";
    }
    
    @GetMapping("/books/{book_id}/show")
    public String show(@PathVariable("book_id") Long id, Model model) {
    	Book book = bookService.findBook(id);
    	model.addAttribute("Book", book);
    	return "books/show.jsp";
    }
    
    @GetMapping("/books/{book_id}/edit")
    public String editBook(Model model, @PathVariable("book_id") Long id) {
    	 Book book = bookService.findBook(id);
    	 model.addAttribute("book", book);
    	 return "books/edit.jsp";
    }
    
    @PutMapping("/books/{id}")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult results) {
    	if(results.hasErrors()) {
			return "books/edit.jsp";
		}
		bookService.createOrUpdateBook(book);
		return "redirect:/";
    }
    
    @DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
    
//    public BooksController(BookService bookService) {
//        this.bookService = bookService;
//    }
//    @RequestMapping("/books")
//    public String index(Model model) {
//        List<Book> books = bookService.allBooks();
//        model.addAttribute("books", books);
//        return "/books/index.jsp";
//    }
    
//    @RequestMapping("/books/new")
//    public String newBook(@ModelAttribute("book") Book book) {
//        return "/books/new.jsp";
//    }
    
//    @RequestMapping(value="/books", method=RequestMethod.POST)
//    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//        if (result.hasErrors()) {
//            return "/books/new.jsp";
//        } else {
//            bookService.createBook(book);
//            return "redirect:/books";
//        }
//    }
    
//    @RequestMapping("/books/{id}/edit")
//    public String edit(@PathVariable("id") Long id, Model model) {
//        Book book = bookService.findBook(id);
//        model.addAttribute("book", book);
//        return "/books/edit.jsp";
//    }
    
//    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
//    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//        if (result.hasErrors()) {
//            return "/books/edit.jsp";
//        } else {
//            bookService.createBook(book);
//            return "redirect:/books";
//        }
//    }
    
//    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
//    public String destroy(@PathVariable("id") Long id) {
//        bookService.deleteBook(id);
//        return "redirect:/books";
//    }
}