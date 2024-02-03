package com.microsservicos.pikachu.produtor.dto;

import java.sql.Date;
import java.util.List;

public class TransactionDTO {
	
	private String id;
	private Date transaction_date;
	private Double amount;
	private PersonDTO person;
	private List<InstallmentDTO> installment;
	
	public TransactionDTO(String id, Date transaction_date, Double amount, PersonDTO person,
			List<InstallmentDTO> installment) {
		this.id = id;
		this.transaction_date = transaction_date;
		this.amount = amount;
		this.person = person;
		this.installment = installment;
	}
	
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
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	public List<InstallmentDTO> getInstallment() {
		return installment;
	}
	public void setInstallment(List<InstallmentDTO> installment) {
		this.installment = installment;
	}
	
}
