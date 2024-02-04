package com.microsservicos.pikachu.consumidor.model;

import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name ="tb_transaction")
public class Transaction {
	
	@Id
	@NotBlank
	private String id;
	
	@NotNull
	private String transaction_date;
	
	@NotNull
	private Double amount; 
	
	@ManyToOne
	@JsonIgnoreProperties("transactions")
	private Person person;
	
	@OneToMany
	@JsonIgnoreProperties("transaction")
	private List<Installment> installments;
	
	@Column(columnDefinition = "char default 'P'")
    private char status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(String transaction_date) {
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
	public List<Installment> getInstallments() {
		// sort para organizar a lista de Installments
		installments.sort(Comparator.comparingInt(Installment::getInstallment_number));
		return installments;
	}
	
	public void setInstallments(List<Installment> installments) {
	
		this.installments = installments;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		
		this.status = status;
	}
	
	
	
}