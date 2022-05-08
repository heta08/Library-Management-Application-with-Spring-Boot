package com.group5.librarymanagement.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

@Entity
@Table(name = "issuedetails")
public class IssueDetails {
	
	@Id
	private Long id;
	
	private Date issueDate;
	
	private Date returnDate;
	
	private Date actualReturnDate;
	
	private String name;
	
	private String first_name;

	public Long getId() {
		return id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public Date getActualReturnDate() {
		return actualReturnDate;
	}

	public String getName() {
		return name;
	}

	public String getFirst_name() {
		return first_name;
	}
	
	
	
}
