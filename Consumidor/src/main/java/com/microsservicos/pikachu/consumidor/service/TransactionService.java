package com.microsservicos.pikachu.consumidor.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsservicos.pikachu.consumidor.dto.DataDTO;
import com.microsservicos.pikachu.consumidor.model.Installment;
import com.microsservicos.pikachu.consumidor.model.Person;
import com.microsservicos.pikachu.consumidor.model.Transaction;
import com.microsservicos.pikachu.consumidor.repository.PersonRepository;
import com.microsservicos.pikachu.consumidor.repository.TransactionRepository;

@Service
public class TransactionService {


	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private PersonRepository personRepository;
	

	public Transaction createTransaction(DataDTO dataDTO) {
		

		Transaction transaction = new Transaction();
		
		transaction.setId(dataDTO.getId_transaction());	
		transaction.setTransaction_date(dataDTO.getDate());
		transaction.setAmount(dataDTO.getAmount());
		
			if(!transactionRepository.existsById(dataDTO.getId_transaction())) {
				transactionRepository.save(transaction);
			}

		return transaction;
	}
	
	
	public Transaction updateTransaction(Transaction transaction,Person person, List<Installment> installments){
		
		
		if(personRepository.existsById(person.getId())) {
			transaction.setPerson(person);
		}		
		
		transaction.setInstallments(installments);
		
		transactionRepository.save(transaction);
		
		return transaction;
	}
	
}
