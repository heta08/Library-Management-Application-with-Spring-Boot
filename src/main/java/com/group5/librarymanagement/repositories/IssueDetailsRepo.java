package com.group5.librarymanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.group5.librarymanagement.model.IssueDetails;

@Repository
public interface IssueDetailsRepo extends CrudRepository <IssueDetails, Long> {

}
