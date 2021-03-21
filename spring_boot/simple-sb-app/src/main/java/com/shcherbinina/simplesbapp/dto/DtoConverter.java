package com.shcherbinina.simplesbapp.dto;

import com.shcherbinina.simplesbapp.entity.Customer;
import com.shcherbinina.simplesbapp.entity.Ticket;

import java.util.stream.Collectors;

public class DtoConverter {
    public static CustomerDto getCustomerDto(Customer customer) {
        CustomerDto dto = new CustomerDto();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setTickets(customer.getTickets().stream().map(ticket -> DtoConverter.getTicketDto(ticket)).collect(Collectors.toList()));
        return dto;
    }

    public static TicketDto getTicketDto(Ticket ticket) {
        TicketDto dto = new TicketDto();
        dto.setId(ticket.getId());
        dto.setDestination(ticket.getDestination());
        dto.setDuration(ticket.getDuration());
        dto.setFlightDate(ticket.getFlightDate());
        dto.setSource(ticket.getSource());
        return dto;
    }
}
