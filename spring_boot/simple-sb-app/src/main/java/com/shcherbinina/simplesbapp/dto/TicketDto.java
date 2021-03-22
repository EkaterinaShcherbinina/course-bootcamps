package com.shcherbinina.simplesbapp.dto;

import com.shcherbinina.simplesbapp.controllers.FlightController;
import com.shcherbinina.simplesbapp.entity.Ticket;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Data
public class TicketDto extends RepresentationModel {
    @NotEmpty
    private int id;

    @NotEmpty
    private String source;

    @NotEmpty
    private String destination;

    @NotEmpty
    private String duration;

    @NotEmpty
    private Date flightDate;

    @NotEmpty
    private int place;

    private int customerId;

    public TicketDto(Ticket ticket) {
        id = ticket.getId();
        source = ticket.getSource();
        destination = ticket.getDestination();
        duration = ticket.getDuration();
        flightDate = ticket.getFlightDate();
        place = ticket.getPlace();
        addLinks();
    }

    private void addLinks() {
        add(linkTo(methodOn(FlightController.class).cancelFlight(id)).withRel("canceling"));
    }
}
