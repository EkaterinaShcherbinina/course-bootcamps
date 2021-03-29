package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.BankDto;

import java.util.List;

public interface IBankService {
    void newBank(BankDto bank);
    List<BankDto> allBanks();
    BankDto getById(long id);
}
