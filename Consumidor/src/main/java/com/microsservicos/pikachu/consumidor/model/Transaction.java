package com.microsservicos.pikachu.consumidor.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Transaction {
	
	@Id
	@NotBlank
	private String id;
	
	@NotNull
	private Date transaction_date;
	
	@NotNull
	private Double amount; 
	
	@ManyToOne
	@JsonIgnoreProperties("transactions")
	private Person person;
	
	@OneToMany
	@JsonIgnoreProperties("transactions")
	private List<Installment> installments;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Installment> getInstallment() {
		return installments;
	}
	public void setInstallment(List<Installment> installment) {
		this.installments = installment;
	}
	
}