package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.BookedTicket;
import com.shcherbinina.simplesbapp.dto.TicketDto;
import com.shcherbinina.simplesbapp.entity.Customer;
import com.shcherbinina.simplesbapp.entity.Ticket;
import com.shcherbinina.simplesbapp.exceptions.EntityNotFoundException;
import com.shcherbinina.simplesbapp.repositories.CustomerRepository;
import com.shcherbinina.simplesbapp.repositories.TicketRepository;
import com.shcherbinina.simplesbapp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightBookingService implements IBookingService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    CustomerRepository customerRepository;
    private String message = "Ticket is already booked";
    private String sourceTicketsMessage = "There aren't tickets with such source";

    @Override
    @Transactional
    public void bookTicket(BookedTicket bookedTicket) {
        Ticket ticket = ticketRepository.findById(bookedTicket.getTicketId());
        if(ticket.getCustomer() != null) throw new EntityNotFoundException(message);
        Customer customer = customerRepository.findById(bookedTicket.getCustomerId()).orElseThrow(
                () -> new EntityNotFoundException(String.format(Constants.customerNotFound, bookedTicket.getCustomerId())));
        ticket.setCustomer(customer);
        ticketRepository.save(ticket);
    }

    @Override
    public void cancelTicket(int id) {
        System.out.println("Deleted: " + id);
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
        return new TicketDto(ticket);
    }

    @Override
    public List<TicketDto> getTicketsBySource(String source) {
        List<TicketDto> list = null;
        try {
            list = ticketRepository.findBySource(source).stream()
                    .map(TicketDto :: new).collect(Collectors.toList());

        } catch (Exception ex) {

        }
        if(list == null || list.size() == 0)
            throw new EntityNotFoundException(sourceTicketsMessage);
        return list;
    }
}
