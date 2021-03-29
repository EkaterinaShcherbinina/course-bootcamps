package com.shcherbinina.simplesbapp.controllers;

import com.shcherbinina.simplesbapp.dto.AccountDto;
import com.shcherbinina.simplesbapp.entity.Customer;
import com.shcherbinina.simplesbapp.services.AccountService;
import com.shcherbinina.simplesbapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public AccountDto getAccount(@PathVariable("id") long id) {
        return accountService.getAccount(id);
    }

    @GetMapping("/customer={id}")
    public List<AccountDto> allAccountsForCustomer(@PathVariable("id") int id) {
        return accountService.getAccountsForCustomer(id);
    }

    @PostMapping(value="/new")
    public ResponseEntity<Object> newAccount(@RequestBody AccountDto account) {
        accountService.addNewAccount(account);
        return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
    }
}
