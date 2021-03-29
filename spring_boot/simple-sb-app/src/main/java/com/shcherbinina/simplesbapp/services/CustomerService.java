package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.CustomerDto;
import com.shcherbinina.simplesbapp.entity.Customer;
import com.shcherbinina.simplesbapp.exceptions.EntityNotFoundException;
import com.shcherbinina.simplesbapp.repositories.CustomerRepository;
import com.shcherbinina.simplesbapp.utils.Constants;
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
        return customerRepository.findAll().stream().map(CustomerDto::new).collect(Collectors.toList());
    }

    @Override
    public void addNewCustomer(CustomerDto newCustomer) {
        Customer customer = new Customer();
        customer.setName(newCustomer.getName());
        customer.setEmail(newCustomer.getEmail());
        customer.setPhoneNumber(newCustomer.getPhoneNumber());
        customerRepository.save(customer);
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        return new CustomerDto(customerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format(Constants.customerNotFound, id))));
    }

    @Override
    public CustomerDto getCustomerByIdJdbc(int id) {
        return new CustomerDto(customerRepository.customerById(id));
    }
}
