package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.AccountDto;

import java.util.List;

public interface IAccountService {
    AccountDto getAccount(long id);
    List<AccountDto> getAccountsForCustomer(int customerId);
    void addNewAccount(AccountDto account);
}
