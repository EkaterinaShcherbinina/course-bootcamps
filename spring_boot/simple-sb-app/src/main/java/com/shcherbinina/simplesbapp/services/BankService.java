package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.BankDto;
import com.shcherbinina.simplesbapp.exceptions.EntityNotFoundException;
import com.shcherbinina.simplesbapp.repositories.BankRepository;
import com.shcherbinina.simplesbapp.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService implements IBankService {
    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public void newBank(BankDto bank) {

    }

    @Override
    public List<BankDto> allBanks() {
        return null;
    }

    @Override
    public BankDto getById(long id) {
        return new BankDto(bankRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format(Constants.bankNotFound, id))));
    }
}
