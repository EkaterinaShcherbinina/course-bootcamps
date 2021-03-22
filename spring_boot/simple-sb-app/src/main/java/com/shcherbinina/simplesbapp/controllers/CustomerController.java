package com.shcherbinina.simplesbapp.controllers;

import com.shcherbinina.simplesbapp.dto.CustomerDto;
import com.shcherbinina.simplesbapp.entity.Customer;
import com.shcherbinina.simplesbapp.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public List<CustomerDto> allCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(value="/{id}")
    public CustomerDto getCustomer(@PathVariable("id") int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping(value="/new")
    public ResponseEntity<Object> newCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
        return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
    }
}
