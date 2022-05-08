package com.group5.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.group5.librarymanagement.model.Book;
import com.group5.librarymanagement.model.Fine;
import com.group5.librarymanagement.model.IssueBooks;
import com.group5.librarymanagement.repositories.FineRepository;
import com.group5.librarymanagement.repositories.IssueRepository;


import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IssueService {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private IssueRepository issueRepo;
	
	@Autowired
	private FineRepository fineRepo;
	
	
//	private Book book;
	
	public List<IssueBooks> getIssuedBooks() {
		List<IssueBooks> issuedBooks = issueRepo.findAll();
		return issuedBooks.stream().filter(issuedBook -> issuedBook.isActive()).collect(Collectors.toList());
	}
	
	public IssueBooks getBookById(Long id) {
		Optional<IssueBooks> ib= issueRepo.findById(id); 
		if(ib.isPresent())
		{
//			book.setStatus("Unavailable");
			return ib.get();
		}
		else {
			IssueBooks nobooks = null;
			return nobooks;
		}
		
	}
	
 	public IssueBooks newIssue(IssueBooks i) {		
		long millis = System.currentTimeMillis();
		Date d = new Date(millis);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, 7);
		
		Date returnDate = new Date(cal.getTimeInMillis());
		i.setIssueDate(d);
		i.setReturnDate(returnDate);
		i.setActualReturnDate(null);
		i.setIncurredFine(0L);
		i.setActive(true);
		
		IssueBooks newIssue = issueRepo.save(i);
		
		Book book = bookService.getBook(i.getBookId());
		book.setIsIssued(true);
		book.setStatus("Unavailable");
		bookService.update(book);
		
		return newIssue;
	}
	
	public IssueBooks returnBook(Long id) {
		
		IssueBooks issueBooks = issueRepo.getOne(id);
		
		long millis = System.currentTimeMillis();
		Date d = new Date(millis);
		issueBooks.setActualReturnDate(d);
		
		
		//calculate fine
		java.util.Date utilReturnDate = new java.util.Date(issueBooks.getReturnDate().getTime());
		java.util.Date utilActualReturnDate = new java.util.Date(d.getTime());
		
		long incurredFine = ChronoUnit.DAYS.between(utilReturnDate.toInstant(), utilActualReturnDate.toInstant());
		
		if (incurredFine > 0)
			issueBooks.setIncurredFine(incurredFine);
		else
			issueBooks.setIncurredFine(0L);
		issueBooks.setActive(false);
		issueRepo.save(issueBooks);
		
		Book book = bookService.getBook(issueBooks.getBookId());
		
		book.setIsIssued(false);
		book.setStatus("Available");
		bookService.update(book);
		
		Fine fine = new Fine();
		fine.setIssueId(id);
		fine.setIncurredFine(incurredFine);
		fine.setUserId(issueBooks.getUserId());
		
		fineRepo.save(fine);
		
		return issueBooks;
	}
	
	

}
