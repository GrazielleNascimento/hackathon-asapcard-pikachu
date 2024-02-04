package com.microsservicos.pikachu.consumidor.dto;

public class DataDTO {
	
	private String id_transaction;
	private String date;
	private String id_person;
	private String nome;
	private Short idade;
	private Double amount;

	public DataDTO(String id_transaction, String date, String id_person, String nome, Short idade, Double amount) {
		this.id_transaction = id_transaction;
		this.date = date;
		this.id_person = id_person;
		this.nome = nome;
		this.idade = idade;
		this.amount = amount;
	}

	public String getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(String id_transaction) {
		this.id_transaction = id_transaction;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId_person() {
		return id_person;
	}

	public void setId_person(String id_person) {
		this.id_person = id_person;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Short getIdade() {
		return idade;
	}

	public void setIdade(Short idade) {
		this.idade = idade;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
}