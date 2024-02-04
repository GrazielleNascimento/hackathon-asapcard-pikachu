package com.microsservicos.pikachu.consumidor.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.microsservicos.pikachu.consumidor.dto.DataDTO;
import com.microsservicos.pikachu.consumidor.service.DataDTOService;

@Component
public class DataDTOController {
	
	@Autowired
	private DataDTOService dataDTOService;
	
//	@PostMapping
//	public ResponseEntity<DataDTO>  post(@RequestBody DataDTO dataDTO){
//		
//
//		return ResponseEntity.ok(dataDTOService.saveAllByDataDTO(dataDTO));
//		}
	
	
	@RabbitListener(queues = "transactionQueue")
    public void receberArquivo(DataDTO dataDTO) {
        // Implemente a lógica para processar o conteúdo do arquivo recebido

		dataDTOService.saveAllByDataDTO(dataDTO);
		
		
        
     
    }


}
