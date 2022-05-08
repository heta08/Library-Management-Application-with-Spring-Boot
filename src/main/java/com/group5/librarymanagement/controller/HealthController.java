package com.group5.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.group5.librarymanagement.model.IssueBooks;
import com.group5.librarymanagement.services.IssueService;

@Controller
public class HealthController {
	
	@Autowired
	IssueService issueService;
	
	
	@GetMapping("/health")
    @ResponseBody
//	public String health() {
//		return "App is up and running";
//	}
    
    public IssueBooks IssueBook(){
		IssueBooks i = new IssueBooks();
		i.setUserId(1L);
		i.setBookId(1L);
		IssueBooks issueBooks = issueService.newIssue(i);
		return issueBooks;
	}

	
	@GetMapping("/return")
    @ResponseBody
//	public String health() {
//		return "App is up and running";
//	}
    
    public IssueBooks returnBook(){
		IssueBooks issueBooks = issueService.returnBook(1L);
		return issueBooks;
	}
}
