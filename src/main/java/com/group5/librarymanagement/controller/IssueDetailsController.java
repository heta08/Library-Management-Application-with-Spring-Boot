package com.group5.librarymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.group5.librarymanagement.model.IssueDetails;
import com.group5.librarymanagement.services.IssueDetailsService;

@Controller
public class IssueDetailsController {
	
	@Autowired
	private IssueDetailsService issueServ;
	
	@GetMapping("/showissue")
	public String showbooks(Model model) {
		System.out.print("inside show issue");	
		List<IssueDetails> list=new ArrayList<IssueDetails>();  
		list=issueServ.getIssues();
		//System.out.print(list.get(0));
		model.addAttribute("issuedbooks", list);
		return "returnBook";
	}

}
