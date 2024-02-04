package com.microsservicos.pikachu.consumidor.service;

import java.util.Collections;
import java.util.Comparator;
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
		List<Installment> installments = installmentService.createInstallment(dataDTO);
		
		List<Transaction> transactions = transactionRepository.findAll();
		
		personService.updatePerson(person, transactions );
		transactionService.updateTransaction(transaction, person, installments);
		installmentService.updateInstallment(installments, transaction);
		
		return dataDTO;

	}
	
}
