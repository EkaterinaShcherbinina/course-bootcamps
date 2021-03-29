package com.shcherbinina.simplesbapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shcherbinina.simplesbapp.controllers.AccountController;
import com.shcherbinina.simplesbapp.controllers.CustomerController;
import com.shcherbinina.simplesbapp.entity.Customer;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
public class CustomerDto extends RepresentationModel {
    @NotEmpty
    private int id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    @Email
    private String email;

    @JsonIgnore
    private List<Integer> ticketsIds;

    @JsonIgnore
    private List<Long> accountsIds;

    public CustomerDto(){}

    public CustomerDto(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        phoneNumber = customer.getPhoneNumber();
        email = customer.getEmail();
        ticketsIds = customer.getTickets().stream().map(ticket -> ticket.getId()).collect(Collectors.toList());
        accountsIds = customer.getAccounts().stream().map(account -> account.getId()).collect(Collectors.toList());
        addLinks();
    }

    private void addLinks() {
        add(linkTo(CustomerController.class).withRel("customers"));
        add(linkTo(methodOn(CustomerController.class).getCustomer(id)).withSelfRel());
        add(linkTo(methodOn(AccountController.class).allAccountsForCustomer(id)).withRel("accounts"));
    }
}
