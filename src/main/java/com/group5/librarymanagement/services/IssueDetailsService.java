package com.group5.librarymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group5.librarymanagement.model.IssueDetails;
import com.group5.librarymanagement.repositories.IssueDetailsRepo;

@Service
public class IssueDetailsService {
	
	@Autowired
	private IssueDetailsRepo issueRepo;
	
	public List<IssueDetails> getIssues(){
		return (List<IssueDetails>) issueRepo.findAll();
		
	}

}
