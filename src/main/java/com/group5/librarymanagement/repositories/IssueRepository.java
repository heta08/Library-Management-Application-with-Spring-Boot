package com.group5.librarymanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group5.librarymanagement.model.Book;
import com.group5.librarymanagement.model.IssueBooks;

@Repository

public interface IssueRepository extends JpaRepository <IssueBooks,Long>{

}