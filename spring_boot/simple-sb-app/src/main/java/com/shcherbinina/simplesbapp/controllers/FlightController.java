package com.shcherbinina.simplesbapp.controllers;

import com.shcherbinina.simplesbapp.dto.BookedTicket;
import com.shcherbinina.simplesbapp.dto.TicketDto;
import com.shcherbinina.simplesbapp.services.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightBookingService bookingService;

    @GetMapping(value ="/{source}")
    public List<TicketDto> allTicketsBySource(@PathVariable("source") String source) {
        return bookingService.getTicketsBySource(source);
    }

    @PostMapping("/book-ticket")
    public ResponseEntity<Object> bookTicket(@RequestBody @Valid BookedTicket bookedTicket) {
        bookingService.bookTicket(bookedTicket);
        return new ResponseEntity<>("Booked successfully", HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Object> cancelFlight(@PathVariable("id") final int id) {
        bookingService.cancelTicket(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
