package com.microsservicos.pikachu.consumidor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsservicos.pikachu.consumidor.dto.DataDTO;
import com.microsservicos.pikachu.consumidor.model.Installment;
import com.microsservicos.pikachu.consumidor.model.Transaction;
import com.microsservicos.pikachu.consumidor.repository.InstallmentRepository;

@Service
public class InstallmentService {
	
	@Autowired
	private InstallmentRepository installmentRepository;
	

	
	public List<Installment> createInstallment(DataDTO dataDTO) {

		Long qtd_installment = dataDTO.getQtd_installment();
		double amount = dataDTO.getAmount();
		double installmentValue = amount/qtd_installment; 
		List<Installment> listInstallment = new ArrayList<Installment>();
		
		for(int i = 0; i <= qtd_installment; i++) {
			Installment installment = new Installment();
			
			
			installment.setInstallment_number(i);
			installment.setValue(installmentValue);
			
			installmentRepository.save(installment);
			
			listInstallment.add(installment);
			
		}
		
		return listInstallment;
	}
	
	
	public Installment updateInstallment(Installment installment, Transaction transaction) {
		
		installment.setTransaction(transaction);
		
		installmentRepository.save(installment);
		
		return installment;
	}

}
