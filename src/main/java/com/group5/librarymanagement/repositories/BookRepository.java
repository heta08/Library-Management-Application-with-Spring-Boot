package com.group5.librarymanagement.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group5.librarymanagement.model.User;
import com.group5.librarymanagement.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	@Query("SELECT b FROM Book b WHERE b.name like %:bookName%")
	List<Book> findByName(String bookName);
}
