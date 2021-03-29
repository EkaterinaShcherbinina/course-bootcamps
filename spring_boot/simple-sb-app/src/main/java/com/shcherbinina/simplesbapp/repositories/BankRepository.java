package com.shcherbinina.simplesbapp.repositories;

import com.shcherbinina.simplesbapp.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
