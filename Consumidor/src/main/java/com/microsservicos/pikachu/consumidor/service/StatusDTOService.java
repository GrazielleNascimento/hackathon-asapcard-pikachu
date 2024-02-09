package com.microsservicos.pikachu.consumidor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsservicos.pikachu.consumidor.dto.StatusDTO;
import com.microsservicos.pikachu.consumidor.model.Transaction;
import com.microsservicos.pikachu.consumidor.repository.TransactionRepository;

@Service
public class StatusDTOService {

	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public StatusDTO createStatusDTO(String statusString ) throws JsonMappingException, JsonProcessingException {
		
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Converte a String JSON para um objeto JsonNode
        StatusDTO statusDTO = objectMapper.readValue(statusString, StatusDTO.class);

		return statusDTO;
	}
	
	public StatusDTO updateTransactionStatus(StatusDTO statusDTO) {
		String transaction_id = statusDTO.getId_transaction();
		
		Transaction transaction = transactionRepository.findByTransactionId(transaction_id);

		if(transaction != null) {

					
			String transactionPersonID = transaction.getPerson().getId();
			String statusDTOPersonID = statusDTO.getId_person();
			
			if(transactionPersonID.equals(statusDTOPersonID)) {
				
				transaction.setStatus(statusDTO.getStatus());
				transactionRepository.save(transaction);
				return statusDTO;
			}
		}
		return null;
	}
}
