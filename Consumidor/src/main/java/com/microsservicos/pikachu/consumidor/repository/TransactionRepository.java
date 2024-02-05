package com.microsservicos.pikachu.consumidor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microsservicos.pikachu.consumidor.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{

	@Query("SELECT t FROM Transaction t WHERE LOWER(t.status) = LOWER(:status)")
	List<Transaction> findAllByStatusIgnoreCase(@Param("status") char status);

    @Query("SELECT t FROM Transaction t WHERE t.id = :idTransaction")
    Transaction findByIdTransaction(@Param("idTransaction") String idTransaction);
  
}
