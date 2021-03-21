package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.BookedTicket;
import com.shcherbinina.simplesbapp.dto.DtoConverter;
import com.shcherbinina.simplesbapp.dto.TicketDto;
import com.shcherbinina.simplesbapp.entity.Customer;
import com.shcherbinina.simplesbapp.entity.Ticket;
import com.shcherbinina.simplesbapp.exceptions.EntityNotFoundException;
import com.shcherbinina.simplesbapp.repositories.CustomerRepository;
import com.shcherbinina.simplesbapp.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlightBookingService implements IBookingService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    CustomerRepository customerRepository;
    private String message = "Ticket is already booked";

    @Override
    @Transactional
    public void bookTicket(BookedTicket bookedTicket) {
        Ticket ticket = ticketRepository.findById(bookedTicket.getTicketId());
        if(ticket.getCustomer() != null) throw new EntityNotFoundException(message);
        Customer customer = customerRepository.findById(bookedTicket.getCustomerId());
        ticket.setCustomer(customer);
        ticketRepository.save(ticket);
    }

    @Override
    public void cancelTicket() {

    }

    @Override
    @Transactional
    public void updateTicket(TicketDto dto) {
        Ticket ticket = ticketRepository.findById(dto.getId());
        if(ticket != null) {
            ticket.setDestination(dto.getDestination());
            ticket.setDuration(dto.getDuration());
            ticket.setFlightDate(dto.getFlightDate());
            ticket.setPlace(dto.getPlace());
            ticket.setSource(dto.getSource());
            ticketRepository.save(ticket);
        }
    }

    @Override
    public TicketDto getTicket(int id) {
        Ticket ticket = ticketRepository.findById(id);
        return DtoConverter.getTicketDto(ticket);
    }
}
