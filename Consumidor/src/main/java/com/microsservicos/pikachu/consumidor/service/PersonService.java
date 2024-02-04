package com.microsservicos.pikachu.consumidor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		if(!personRepository.existsById(dataDTO.getId_person())) {
			personRepository.save(person);
		}else {
			person = personRepository.getById(person.getId());
		}

		return person;
	}
	
	
	public Optional<Person> updatePerson(Person person, Transaction transaction){
		
		
		if(personRepository.existsById(person.getId())) {
			
			if(person.getTransactions() != null) {
				person.getTransactions().add(transaction);
			} else {
				List<Transaction> transactions = new ArrayList<Transaction>();
				transactions.add(transaction);
				person.setTransactions(transactions);
			}
			
			personRepository.save(person);
			return Optional.of(person);
		}

		return null; 
		
	}
	
	
}
