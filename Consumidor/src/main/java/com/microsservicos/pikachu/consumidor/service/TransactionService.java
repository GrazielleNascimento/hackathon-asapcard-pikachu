package com.microsservicos.pikachu.consumidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsservicos.pikachu.consumidor.model.Installment;
import com.microsservicos.pikachu.consumidor.model.Person;
import com.microsservicos.pikachu.consumidor.model.Transaction;
import com.microsservicos.pikachu.consumidor.repository.TransactionRepository;

@Service
public class TransactionService {


	
	@Autowired
	private TransactionRepository transactionRepository;
	
	

	public Transaction createTransaction(String id_transaction, String date, Double amount) {
		

		Transaction transaction = new Transaction();
		
		transaction.setId(id_transaction);	
		transaction.setTransaction_date(date);
		transaction.setAmount(amount);
		
			if(!transactionRepository.existsById(id_transaction)) {
				transactionRepository.save(transaction);
			}

		return transaction;
	}
	
	
	public Transaction updateTransaction(Transaction transaction,Person person, List<Installment> installments){
		
		transaction.setPerson(person);
		transaction.setInstallments(installments);
		
		transactionRepository.save(transaction);
		
		return transaction;
	}
	
}
