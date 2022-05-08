package com.group5.librarymanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface ReadOnlyRepo <T, ID> extends Repository<T, ID> {
 
    List<T> findAll();
 
    Optional<T> findById(ID id);
     
    long count();
}