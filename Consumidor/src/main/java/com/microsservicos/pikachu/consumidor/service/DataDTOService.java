package com.microsservicos.pikachu.consumidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsservicos.pikachu.consumidor.dto.DataDTO;
import com.microsservicos.pikachu.consumidor.model.Installment;
import com.microsservicos.pikachu.consumidor.model.Person;
import com.microsservicos.pikachu.consumidor.model.Transaction;



@Service
public class DataDTOService {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private InstallmentService installmentService;
	
	
	
	public DataDTO createDataDTO(String dataString ) throws JsonMappingException, JsonProcessingException {
		
		
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Converte a String JSON para um objeto JsonNode
        DataDTO dataDTO = objectMapper.readValue(dataString, DataDTO.class);

       
		return dataDTO;
	}
	
	
	public DataDTO saveAllByDataDTO(DataDTO dataDTO) {
		
		//Mudei aqui para passar individualmente apenas o necessário para os métodos funcionarem. Antes, estava passando dataDTO por completo, mesmo que os métodos não fossem usar todos seus dados.
		//Além disso, evitei o uso excessivo do get em dataDTO, pois agora pego todos os dados e passo individualmente para os métodos, sem repetir o uso do get.
		
		String id_person = dataDTO.getId_person();
		String id_transaction = dataDTO.getId_transaction();
		String nome = dataDTO.getNome();
		short idade = dataDTO.getIdade();
		String data = dataDTO.getDate();
		Double amount = dataDTO.getAmount();
		Long qtd_installment = dataDTO.getQtd_installment();
		
		
		
		Person person = personService.createPerson(id_person, nome, idade);
		Transaction transaction = transactionService.createTransaction(id_transaction, data, amount);
		List<Installment> installments = installmentService.createInstallment(qtd_installment,amount, transaction);
	
		
		personService.updatePerson(person, transaction );
		transactionService.updateTransaction(transaction, person, installments);
		
		return dataDTO;

	}
	
}
