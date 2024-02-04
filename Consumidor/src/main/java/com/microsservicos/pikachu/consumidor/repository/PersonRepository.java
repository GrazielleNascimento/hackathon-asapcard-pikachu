package com.microsservicos.pikachu.consumidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsservicos.pikachu.consumidor.model.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

}
