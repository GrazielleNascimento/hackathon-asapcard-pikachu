package com.microsservicos.pikachu.consumidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsservicos.pikachu.consumidor.model.Person;
import com.microsservicos.pikachu.consumidor.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Person>> getAll(){
		
		
		return ResponseEntity.ok(personRepository.findAll());
		}
}
