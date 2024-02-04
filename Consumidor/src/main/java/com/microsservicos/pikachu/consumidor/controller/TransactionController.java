package com.microsservicos.pikachu.consumidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservicos.pikachu.consumidor.model.Transaction;
import com.microsservicos.pikachu.consumidor.repository.TransactionRepository;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepository;
	
//	@GetMapping("/all")
//	public ResponseEntity<List<Transaction>> getAll(){
//		
//		
//		return ResponseEntity.ok(transactionRepository.findAll());
//		}
	
	@GetMapping("/update")
	public ResponseEntity<List<Transaction>> getAll(){
		
		List<Transaction> transactions = transactionRepository.findAll();
		
		for(int i = 0 ; i <= transactions.size() ; i++) {
			Transaction transaction = transactions.get(i);
			
			transaction.setStatus('P');
			
			transactionRepository.save(transaction);
		}
		
		return ResponseEntity.ok(transactionRepository.findAll());
		}
	
}
