package com.shcherbinina.simplesbapp.dto;

import com.shcherbinina.simplesbapp.controllers.AccountController;
import com.shcherbinina.simplesbapp.entity.Account;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
public class AccountDto extends RepresentationModel {
    @NotEmpty
    private long id;

    @NotEmpty
    private BigDecimal balance;

    @NotEmpty
    private int customerId;

    @NotEmpty
    private long bankId;

    public AccountDto(){}

    public AccountDto(Account account) {
        id = account.getId();
        balance = account.getBalance();
        customerId = account.getCustomer().getId();
        bankId = account.getBank().getId();
        addLinks();
    }

    private void addLinks() {
        add(linkTo(AccountController.class).withRel("accounts"));
        add(linkTo(methodOn(AccountController.class).getAccount(id)).withSelfRel());
    }
}
