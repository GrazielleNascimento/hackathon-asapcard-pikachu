package com.microsservicos.pikachu.consumidor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsservicos.pikachu.consumidor.model.Person;
import com.microsservicos.pikachu.consumidor.model.Transaction;
import com.microsservicos.pikachu.consumidor.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	public Person createPerson(String id_person, String nome, Short idade) {
		Person person = new Person();
		
		person.setId(id_person);
		person.setName(nome);
		person.setAge(idade);
		
		if(!personRepository.existsById(id_person)) {
			personRepository.save(person);
		}
		
		return person;
	}
	
	
	public Optional<Person> updatePerson(Person person, Transaction transaction){
		
		
		
			
			List<Transaction> transactions = person.getTransactions();
			if (transactions == null) {
			    transactions = new ArrayList<>();
			    person.setTransactions(transactions);
			}
			transactions.add(transaction);

			personRepository.save(person);
			return Optional.of(person);
		
		
		
	}
	
	
}
