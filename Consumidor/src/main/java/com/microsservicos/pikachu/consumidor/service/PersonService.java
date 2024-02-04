package com.microsservicos.pikachu.consumidor.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsservicos.pikachu.consumidor.model.Person;

@Service
public class PersonService {
	
	String jsonString = "{\"id_transaction\": \"686e9b31-caeb-4908-95d5-931b50a8df9c\", "
            + "\"date\": \"2023-12-28T06:18:12Z\", "
            + "\"id_person\": \"09326655407\", "
            + "\"nome\": \"Bruce Wayne\", "
            + "\"idade\": \"42\", "
            + "\"amount\": \"87.28\" }";

	public void processPersonJson() throws JsonMappingException, JsonProcessingException {
		createPerson(jsonString);
	}

	public void createPerson(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(json);
		
		String id_person = jsonNode.get("id_person").asText();
		String name = jsonNode.get("nome").asText(); // Corrigi o nome da chave para "nome"
		int ageInt = jsonNode.get("idade").asInt(); // Corrigi o nome da chave para "idade"
		short ageShort = (short) ageInt;
        
		Person person = new Person();
        
		person.setId(id_person);
		person.setName(name);
		person.setAge(ageShort);
        
		System.out.println(person.toString());
	}
}
