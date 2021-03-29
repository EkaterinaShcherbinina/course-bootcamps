package com.shcherbinina.simplesbapp.dto;

import com.shcherbinina.simplesbapp.controllers.AccountController;
import com.shcherbinina.simplesbapp.controllers.BankController;
import com.shcherbinina.simplesbapp.entity.Account;
import com.shcherbinina.simplesbapp.entity.Bank;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
public class BankDto extends RepresentationModel {
    @NotEmpty
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private long code;

    @NotEmpty
    private String city;

    public BankDto(){}

    public BankDto(Bank bank) {
        id = bank.getId();
        name = bank.getName();
        code = bank.getCode();
        city = bank.getCity();
        addLinks();
    }

    private void addLinks() {
        add(linkTo(BankController.class).withRel("banks"));
        add(linkTo(methodOn(BankController.class).getBank(id)).withSelfRel());
    }
}
