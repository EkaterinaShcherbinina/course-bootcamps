package com.shcherbinina.simplesbapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shcherbinina.simplesbapp.controllers.CustomerController;
import com.shcherbinina.simplesbapp.entity.Customer;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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
    private List<TicketDto> tickets;

    public CustomerDto(){}

    public CustomerDto(Customer customer) {
        id = customer.getId();
        name = customer.getName();
        phoneNumber = customer.getPhoneNumber();
        email = customer.getEmail();
        add(linkTo(CustomerController.class).withRel("customers"));
        //add(linkTo(methodOn(GymMembershipController.class).all(id)).withRel("memberships"));
        add(linkTo(methodOn(CustomerController.class).allCustomers()).withSelfRel());
    }
}