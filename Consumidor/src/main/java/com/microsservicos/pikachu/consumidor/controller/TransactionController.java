package com.microsservicos.pikachu.consumidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservicos.pikachu.consumidor.model.Transaction;
import com.microsservicos.pikachu.consumidor.repository.TransactionRepository;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Transaction>> getAll(){
		
	
		return ResponseEntity.ok(transactionRepository.findAll());
	}
	
	
	@GetMapping("/all/{status}")
	public ResponseEntity<List<Transaction>> getAllByStatus(@PathVariable char status){
		
		
		return ResponseEntity.ok(transactionRepository.findAllByStatusIgnoreCase(status));
	}

}
