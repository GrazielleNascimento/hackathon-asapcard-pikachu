package com.microsservicos.pikachu.consumidor.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.microsservicos.pikachu.consumidor.service.DataDTOService;

@Component
public class DataDTOController {

	@Autowired
	private DataDTOService dataDTOService;
	
	@RabbitListener(queues = "transactionsQueue")
    public void  receberData(String value) throws JsonMappingException, JsonProcessingException {
      
		dataDTOService.saveAllByDataDTO(dataDTOService.createDataDTO(value));
		
    }
}
