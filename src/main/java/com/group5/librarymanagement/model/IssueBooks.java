package com.group5.librarymanagement.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "issue")
@JsonIgnoreProperties(ignoreUnknown=true)
public class IssueBooks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Date issueDate;
	
	private Long bookId;
	
	private Long userId;
	
	private Date returnDate;
	
	private Date actualReturnDate;
	
	private Long incurredFine;
	
	private Boolean isActive;
		
		public Boolean isActive() {
			return isActive;
		}
		public void setActive(Boolean isActive) {
			this.isActive = isActive;
		}

	
	public Date getActualReturnDate() {
		return actualReturnDate;
	}
	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public long getIncurredFine() {
		return incurredFine;
	}
	public void setIncurredFine(long incurredFine) {
		this.incurredFine = incurredFine;
	}
}
