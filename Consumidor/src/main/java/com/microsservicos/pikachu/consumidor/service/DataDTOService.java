package com.microsservicos.pikachu.consumidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsservicos.pikachu.consumidor.dto.DataDTO;
import com.microsservicos.pikachu.consumidor.model.Installment;
import com.microsservicos.pikachu.consumidor.model.Person;
import com.microsservicos.pikachu.consumidor.model.Transaction;
import com.microsservicos.pikachu.consumidor.repository.TransactionRepository;

@Service
public class DataDTOService {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private InstallmentService installmentService;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	
	public DataDTO saveAllByDataDTO(DataDTO dataDTO) {
		
		Person person = personService.createPerson(dataDTO);
		Transaction transaction = transactionService.createTransaction(dataDTO);
		
		List<Transaction> transactions = transactionRepository.findAll();
		List<Installment> installments = installmentService.createInstallment(dataDTO);
		
		
		personService.updatePerson(person, transactions );
		
		transactionService.updateTransaction(transaction, person, installments);
		
		for(int i = 1; i < installments.size(); i++) {
			Installment installment = installments.get(i);
			
			installmentService.updateInstallment(installment, transaction);
		}
		
		
		return dataDTO;

	}
	
}
