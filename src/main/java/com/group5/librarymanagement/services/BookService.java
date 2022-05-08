package com.group5.librarymanagement.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group5.librarymanagement.model.Book;
import com.group5.librarymanagement.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Book getBook(Long id) {
		return bookRepository.getOne(id);
	}
	
	public Book addBook(Book book) {
		book.setStatus("Available");
		Book saved =  bookRepository.saveAndFlush(book);
		System.out.println(saved);
		return saved;
	}
	
	public Book update(Book book) {
		Book saved =  bookRepository.saveAndFlush(book);
		System.out.println(saved);
		return saved;
	}
	
	public void delete(Long id) {
		List<Long> ids = new ArrayList<>();
		ids.add(id);
		bookRepository.deleteAllByIdInBatch(ids);
	}
	
	public List<Book> getBookByName(String bookName){
		return bookRepository.findByName(bookName);
	}
}
