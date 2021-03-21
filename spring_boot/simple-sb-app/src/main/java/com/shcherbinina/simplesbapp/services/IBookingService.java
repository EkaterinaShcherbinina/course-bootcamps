package com.shcherbinina.simplesbapp.services;

import com.shcherbinina.simplesbapp.dto.BookedTicket;
import com.shcherbinina.simplesbapp.dto.TicketDto;

public interface IBookingService {
    void bookTicket(BookedTicket bookedTicket);
    void cancelTicket();
    void updateTicket(TicketDto ticket);
    TicketDto getTicket(int id);
}
