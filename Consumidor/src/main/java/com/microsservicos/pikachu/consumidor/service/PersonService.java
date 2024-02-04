package com.microsservicos.pikachu.consumidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsservicos.pikachu.consumidor.dto.DataDTO;
import com.microsservicos.pikachu.consumidor.model.Person;
import com.microsservicos.pikachu.consumidor.model.Transaction;
import com.microsservicos.pikachu.consumidor.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	public Person createPerson(DataDTO dataDTO) {
		Person person = new Person();
		
		person.setId(dataDTO.getId_person());
		person.setName(dataDTO.getNome());
		person.setAge(dataDTO.getIdade());
		
        
		personRepository.save(person);
		
		return person;
	}
	
	
	public Person updatePerson(Person person, List<Transaction> transactions){
		
		person.setTransactions(transactions);
		
		personRepository.save(person);
		
		return person;
	}
	
	
}
