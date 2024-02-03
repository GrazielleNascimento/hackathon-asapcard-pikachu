package com.microsservicos.pikachu.produtor.dto;

import java.util.List;

public class PersonDTO {

	private String id;
	private String name;
	private Short age;
	private List<TransactionDTO> transactions;
	
	public PersonDTO(String id, String name, Short age, List<TransactionDTO> transactions) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.transactions = transactions;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Short getAge() {
		return age;
	}
	public void setAge(Short age) {
		this.age = age;
	}
	public List<TransactionDTO> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionDTO> transactions) {
		this.transactions = transactions;
	}
	
	
	
}
