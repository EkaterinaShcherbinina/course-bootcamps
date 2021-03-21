package com.shcherbinina.simplesbapp.dto;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class TicketDto {
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
}
