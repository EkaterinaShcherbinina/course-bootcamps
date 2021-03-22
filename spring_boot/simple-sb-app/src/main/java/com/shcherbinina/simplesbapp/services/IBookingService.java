package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.BookedTicket;
import com.shcherbinina.simplesbapp.dto.TicketDto;

import java.util.List;

public interface IBookingService {
    void bookTicket(BookedTicket bookedTicket);
    void cancelTicket(int id);
    void updateTicket(TicketDto ticket);
    TicketDto getTicket(int id);
    List<TicketDto> getTicketsBySource(String source);
}
