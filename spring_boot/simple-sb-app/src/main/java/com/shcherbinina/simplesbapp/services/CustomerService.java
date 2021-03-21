package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.CustomerDto;
import com.shcherbinina.simplesbapp.dto.DtoConverter;
import com.shcherbinina.simplesbapp.entity.Customer;
import com.shcherbinina.simplesbapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(customer -> DtoConverter.getCustomerDto(customer)).collect(Collectors.toList());
    }

    @Override
    public void addNewCustomer(Customer newCustomer) {
        customerRepository.save(newCustomer);
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        return new CustomerDto(customerRepository.findById(id));
    }

    @Override
    public CustomerDto getCustomerByIdJdbc(int id) {
        return DtoConverter.getCustomerDto(customerRepository.customerById(id));
    }
}
