package com.shcherbinina.simplesbapp.controllers;

import com.shcherbinina.simplesbapp.dto.BookedTicket;
import com.shcherbinina.simplesbapp.dto.CustomerDto;
import com.shcherbinina.simplesbapp.services.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightBookingService bookingService;

    @PostMapping("/book-ticket")
    public ResponseEntity<Object> bookTicket(@RequestBody @Valid BookedTicket bookedTicket) {
        bookingService.bookTicket(bookedTicket);
        return new ResponseEntity<>("Booked successfully", HttpStatus.CREATED);
    }
}
