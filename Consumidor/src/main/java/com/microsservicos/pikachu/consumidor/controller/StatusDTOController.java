package com.microsservicos.pikachu.consumidor.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.microsservicos.pikachu.consumidor.service.StatusDTOService;

@Component
public class StatusDTOController {
	
	
	    @Autowired
		private StatusDTOService statusDTOService;
		
		
		@RabbitListener(queues = "statusQueue")
	    public void receberStatus(String value) throws JsonMappingException, JsonProcessingException {
	      
			
		    try {
		        statusDTOService.updateTransactionStatus(statusDTOService.createStatusDTO(value));
		    } catch (RuntimeException e) {
		      
		    	e.printStackTrace();
		    }
	     
	    }
		


	
}
