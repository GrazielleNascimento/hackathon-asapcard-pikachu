package com.microsservicos.pikachu.consumidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microsservicos.pikachu.consumidor.model.Person;

public interface PersonRepository extends JpaRepository<Person, String> {

	
    @Query("SELECT p FROM Person p WHERE p.id = :idPerson")
    Person findByIdPerson(@Param("idPerson") String idPerson);
}
