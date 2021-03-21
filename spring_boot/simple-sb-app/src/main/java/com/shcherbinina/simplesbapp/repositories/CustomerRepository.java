package com.shcherbinina.simplesbapp.repositories;

import com.shcherbinina.simplesbapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, CustomJdbcRepository<Customer> {
    Customer findById(int id);
}
