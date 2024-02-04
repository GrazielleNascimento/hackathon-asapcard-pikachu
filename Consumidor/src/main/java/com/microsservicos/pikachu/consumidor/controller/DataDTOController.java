package com.microsservicos.pikachu.consumidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservicos.pikachu.consumidor.dto.DataDTO;
import com.microsservicos.pikachu.consumidor.service.DataDTOService;

@RestController
@RequestMapping("/data")
public class DataDTOController {
	
	@Autowired
	private DataDTOService dataDTOService;
	
	@PostMapping
	public ResponseEntity<DataDTO>  post(@RequestBody DataDTO dataDTO){
		

		return ResponseEntity.ok(dataDTOService.saveAllByDataDTO(dataDTO));
		}
	
	


}
