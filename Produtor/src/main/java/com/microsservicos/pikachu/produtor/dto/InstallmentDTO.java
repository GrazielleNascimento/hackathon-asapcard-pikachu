package com.microsservicos.pikachu.produtor.dto;

public class InstallmentDTO {

	private String id;
	private Integer installment_number;
	private Double value;
	private TransactionDTO transaction;

	public InstallmentDTO(String id, Integer installment_number, Double value, TransactionDTO transaction) {
		this.id = id;
		this.installment_number = installment_number;
		this.value = value;
		this.transaction = transaction;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getInstallment_number() {
		return installment_number;
	}
	public void setInstallment_number(Integer installment_number) {
		this.installment_number = installment_number;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public TransactionDTO getTransaction() {
		return transaction;
	}
	public void setTransaction(TransactionDTO transaction) {
		this.transaction = transaction;
	}
	
	
	
	
}
