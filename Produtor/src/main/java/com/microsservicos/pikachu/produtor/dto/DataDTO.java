package com.microsservicos.pikachu.produtor.dto;

import com.opencsv.bean.CsvBindByPosition;

public class DataDTO {
	
	@CsvBindByPosition(position = 0)
	private String id_transaction;
	@CsvBindByPosition(position = 1)
	private String date;
	@CsvBindByPosition(position = 2)
	private String id_person;
	@CsvBindByPosition(position = 3)
	private String nome;
	@CsvBindByPosition(position = 4)
	private Short idade;
	@CsvBindByPosition(position = 5)
	private Double amount;
	@CsvBindByPosition(position = 6)
	private int qtd_installment;
	
	
	public DataDTO() {

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

	public int getQtd_installment() {
		return qtd_installment;
	}

	public void setQtd_installment(int qtd_installment) {
		this.qtd_installment = qtd_installment;
	}
	
	
	
	
}
