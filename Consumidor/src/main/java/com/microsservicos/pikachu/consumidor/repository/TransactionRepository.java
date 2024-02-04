package com.microsservicos.pikachu.consumidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsservicos.pikachu.consumidor.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String>{

}
