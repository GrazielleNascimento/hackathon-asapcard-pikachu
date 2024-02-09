package com.microsservicos.pikachu.consumidor.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microsservicos.pikachu.consumidor.model.Installment;
import com.microsservicos.pikachu.consumidor.model.Transaction;
import com.microsservicos.pikachu.consumidor.repository.InstallmentRepository;

@Service
public class InstallmentService {
	
	@Autowired
	private InstallmentRepository installmentRepository;
	

	
	public List<Installment> createInstallment(Long qtd_installment, Double amount, Transaction transaction) {
	    if (qtd_installment <= 0) {
	        throw new IllegalArgumentException("A quantidade de parcelas deve ser maior que zero.");
	    }

	    double installmentValue = amount / qtd_installment;
	    List<Installment> installments = new ArrayList<>();

	    for (int i = 1; i <= qtd_installment; i++) {
	        Installment installment = new Installment();
	        installment.setInstallment_number(i);
	        installment.setValue(installmentValue);

	        // Associar a parcela à transação
	        installment.setTransaction(transaction);

	        // Salvar a parcela
	        installmentRepository.save(installment);

	        installments.add(installment);
	    }

	    // Ordenar as parcelas por número de parcela
	    Collections.sort(installments, Comparator.comparingInt(Installment::getInstallment_number));

	    return installments;
	}
	


}
