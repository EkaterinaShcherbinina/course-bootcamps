package com.shcherbinina.simplesbapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
public class BookedTicket {
    @Positive
    @NotEmpty
    int customerId;
    @Positive
    @NotEmpty
    int ticketId;
}
