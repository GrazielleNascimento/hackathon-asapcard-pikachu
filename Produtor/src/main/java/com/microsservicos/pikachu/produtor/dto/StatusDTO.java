package com.microsservicos.pikachu.produtor.dto;

import com.opencsv.bean.CsvBindByPosition;

public class StatusDTO {

	@CsvBindByPosition(position = 0)
	private String id_transaction;
	@CsvBindByPosition(position = 1)
	private String date;
	@CsvBindByPosition(position = 2)
	private String id_person;
	@CsvBindByPosition(position = 3)
	private char status;

	public StatusDTO() {

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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
}