package com.microsservicos.pikachu.consumidor.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_consumidores")
public class Person {
	
	@Id
	@NotBlank
	private String id;
	
	@Size(min = 2, max = 150, message = "O nome deve ter no mínimo 2 e no máximo 150 caracteres.")
	private String name;
	
	@NotNull
	@Min(value = 1, message = "O valor mínimo permitido para a idade é 1")
    @Max(value = 120, message = "O valor máximo permitido para a idade é 120")
	private Short age;
	
	@OneToMany
	@JsonIgnoreProperties("person")
	private List<Transaction> transactions;

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
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
}