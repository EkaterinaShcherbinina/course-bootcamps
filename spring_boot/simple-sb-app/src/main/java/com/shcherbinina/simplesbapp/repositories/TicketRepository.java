package com.shcherbinina.simplesbapp.repositories;

import com.shcherbinina.simplesbapp.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    Ticket findById(int id);
    List<Ticket> findBySource(String source);
}
