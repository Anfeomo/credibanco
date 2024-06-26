package com.nexus.credibanco.repository;

import com.nexus.credibanco.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM transaction t WHERE t.transactionId = :transactionId")
    Transaction getByTransactionId(@Param("transactionId") String transactionId);
}
