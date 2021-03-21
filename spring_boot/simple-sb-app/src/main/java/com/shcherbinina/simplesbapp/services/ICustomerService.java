package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.CustomerDto;
import com.shcherbinina.simplesbapp.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> getAllCustomers();
    void addNewCustomer(Customer newCustomer);
    CustomerDto getCustomerById(int id);
    CustomerDto getCustomerByIdJdbc(int id);
}
