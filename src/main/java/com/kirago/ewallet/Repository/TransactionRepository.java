package com.kirago.ewallet.Repository;

import com.kirago.ewallet.Model.Transaction;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transaction, String> {

    Optional<Transaction> findById(String id);

    void deleteById(String id);

    Transaction save(Transaction transaction);
    
}
