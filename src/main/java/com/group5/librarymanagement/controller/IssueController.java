package com.group5.librarymanagement.controller;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group5.librarymanagement.model.Book;
import com.group5.librarymanagement.model.IssueBooks;
import com.group5.librarymanagement.model.IssueDetails;
import com.group5.librarymanagement.services.BookService;
import com.group5.librarymanagement.services.IssueService;

@Controller
public class IssueController {
	
	@Autowired
	private IssueService issueService;
	
	@Autowired
	private BookService bookService;
	
	@PostMapping("/issue")
	public String IssueBook(IssueBooks i, Model model){
		IssueBooks issueBooks = issueService.newIssue(i);

		
		List<IssueBooks> issuedBooks = issueService.getIssuedBooks();
		model.addAttribute("issuedBooks", issuedBooks);	
		return "issuedbook";
		
//		model.addAttribute("books", bookService.getAllBooks());	
//		return "showbook";
	}
	
	@GetMapping("/issue/{id}")
	public String getIssueBook(@PathVariable Long id, Model model){
		IssueBooks ib =issueService.getBookById(id);
		System.out.print(ib.toString());
		model.addAttribute("issue", ib);
		return "returnDetails";
		
	}
	
	
	@PostMapping("/return/{id}")
	public String returnBook(@PathVariable Long id, Model model) {
		IssueBooks returnedBook =  issueService.returnBook(id);
		model.addAttribute("issue", returnedBook);
		model.addAttribute("fine", returnedBook.getIncurredFine());
		return "returnSuccess";
	}
	
	@GetMapping("/issued")
	public String getIssuedBooks(Model model) {
		List<IssueBooks> issuedBooks = issueService.getIssuedBooks();
		model.addAttribute("issuedBooks", issuedBooks);	
		return "issuedbook";
	}

}
