package com.shcherbinina.simplesbapp.repositories;

import com.shcherbinina.simplesbapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
