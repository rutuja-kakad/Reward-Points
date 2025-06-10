package com.RewardProgram.demo.repository;

import com.RewardProgram.demo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "Customer_Transaction", path = "Customer_Transaction")
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
