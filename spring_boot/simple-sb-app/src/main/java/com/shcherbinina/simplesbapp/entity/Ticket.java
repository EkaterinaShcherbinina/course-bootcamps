package com.shcherbinina.simplesbapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    @NotEmpty
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @NonNull
    private String source;

    @NotEmpty
    @NonNull
    private String destination;

    @NotEmpty
    @NonNull
    private String duration;

    @NotEmpty
    @NonNull
    private Date flightDate;

    @NotEmpty
    @NonNull
    private int place;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    Customer customer;

    public void assignToCustomer(Customer customer) {
        if(customer != null) {
            customer.getTickets().add(this);
            this.customer = customer;
        }
    }
}
