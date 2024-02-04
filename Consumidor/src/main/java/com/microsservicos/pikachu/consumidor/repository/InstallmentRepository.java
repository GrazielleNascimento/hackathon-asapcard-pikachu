package com.microsservicos.pikachu.consumidor.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsservicos.pikachu.consumidor.model.Installment;

public interface InstallmentRepository extends JpaRepository<Installment, UUID> {

}

