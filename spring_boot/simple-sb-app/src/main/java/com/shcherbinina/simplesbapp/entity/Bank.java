package com.shcherbinina.simplesbapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long code;

    @Column(name = "city_name", nullable = false)
    private String city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank")
    private List<Account> accounts;
}
