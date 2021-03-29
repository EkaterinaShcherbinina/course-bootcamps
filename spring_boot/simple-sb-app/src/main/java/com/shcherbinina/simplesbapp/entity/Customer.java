package com.shcherbinina.simplesbapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    public Customer(int id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Ticket> tickets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Account> accounts;
}
