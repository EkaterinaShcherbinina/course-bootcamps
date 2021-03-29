package com.shcherbinina.simplesbapp.controllers;

import com.shcherbinina.simplesbapp.dto.BankDto;
import com.shcherbinina.simplesbapp.dto.CustomerDto;
import com.shcherbinina.simplesbapp.services.IBankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {
    private final IBankService bankService;

    public BankController(IBankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public List<BankDto> allBanks() {
        return bankService.allBanks();
    }

    @GetMapping(value="/{id}")
    public BankDto getBank(@PathVariable("id") long id) {
        return bankService.getById(id);
    }
}
