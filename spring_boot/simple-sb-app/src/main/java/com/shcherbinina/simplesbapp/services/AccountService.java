package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.AccountDto;
import com.shcherbinina.simplesbapp.entity.Account;
import com.shcherbinina.simplesbapp.exceptions.EntityNotFoundException;
import com.shcherbinina.simplesbapp.repositories.AccountRepository;
import com.shcherbinina.simplesbapp.repositories.BankRepository;
import com.shcherbinina.simplesbapp.repositories.CustomerRepository;
import com.shcherbinina.simplesbapp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService implements IAccountService{
    private final String accountNotFound = "There isn't an account with id = {0}";
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final BankRepository bankRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository, BankRepository bankRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public AccountDto getAccount(long id) {
        return new AccountDto(accountRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format(accountNotFound, id))));
    }

    @Override
    public List<AccountDto> getAccountsForCustomer(int customerId) {
        return customerRepository.findById(customerId).orElseThrow(
                () -> new EntityNotFoundException(String.format(Constants.customerNotFound, customerId))
        ).getAccounts().stream().map(AccountDto::new).collect(Collectors.toList());
    }

    @Override
    public void addNewAccount(AccountDto account) {
        Account newAccount = new Account();
        newAccount.setBalance(account.getBalance());
        newAccount.setCustomer(customerRepository.findById(account.getCustomerId()).orElseThrow(
                        () -> new EntityNotFoundException(String.format(Constants.customerNotFound, account.getCustomerId()))));
        newAccount.setBank(bankRepository.findById(account.getBankId()).orElseThrow(
                () -> new EntityNotFoundException(String.format(Constants.bankNotFound, account.getBankId()))));
        accountRepository.save(newAccount);
    }
}
