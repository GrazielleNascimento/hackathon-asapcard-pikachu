package com.microsservicos.pikachu.consumidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservicos.pikachu.consumidor.model.Installment;
import com.microsservicos.pikachu.consumidor.repository.InstallmentRepository;

@RestController
@RequestMapping("/installments")
public class InstallmentController {

	
	
	@Autowired
	private InstallmentRepository installmentRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Installment>> getAll(){
		
		
		return ResponseEntity.ok(installmentRepository.findAll());
		}
}
