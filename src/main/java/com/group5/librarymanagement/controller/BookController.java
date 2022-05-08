package com.group5.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group5.librarymanagement.input.RawBook;
import com.group5.librarymanagement.model.Book;
import com.group5.librarymanagement.model.IssueBooks;
import com.group5.librarymanagement.services.BookService;
import com.group5.librarymanagement.services.IssueService;

@Controller

public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public String showbooks(Model model) {
		System.out.print("inside show books");		
		model.addAttribute("books", bookService.getAllBooks());
		return "showbook";
	}
	
	@GetMapping("/{id}")
	public String bookDetails(@PathVariable Long id,Model model) {
		IssueBooks ib = new IssueBooks();
		ib.setBookId(id);
		model.addAttribute("book", bookService.getBook(id));
		model.addAttribute("issueBooks", ib);
		return "bookDetails";
	}
	
	
	@PutMapping("/book")
	public Book update(@RequestBody RawBook input) {
		Book book = bookService.getBook(input.getId());
		book.setName(input.getName());
		book.setDescription(input.getDescription());
		book.setPublication(input.getPublication());
		book.setAuthor(input.getAuthor());
		
		System.out.println(book);
		return bookService.update(book);
	}
	
	@DeleteMapping("/book/{id}")
	public List<Book> delete(@PathVariable Long id) {
		bookService.delete(id);
		return bookService.getAllBooks();
	}
	
	@GetMapping("/addbook")
	public String displayAddBookPage(Model model) {
		System.out.print("inside get books");
		model.addAttribute("book", new Book());
		return "addbook";
	}
	@PostMapping("/addbook")
	public String addBook(Book book,Model model) {
		System.out.print("inside post books");
		System.out.print(book);
		Book addBook=bookService.addBook(book);
		String success ="Book added succesfully";
		model.addAttribute("books", bookService.getAllBooks());
		return "showbook";
	}
	
	@RequestMapping("/search")
	public String searchBookByName(Book book, Model model, String bookName) {
		if(bookName != "") {
			List<Book> booklist = bookService.getBookByName(bookName);
			model.addAttribute("booklist", booklist);
		}
		else {
			List<Book> booklist = bookService.getAllBooks();
			model.addAttribute("booklist", booklist);
		}
		
		return "search";
	}

}
