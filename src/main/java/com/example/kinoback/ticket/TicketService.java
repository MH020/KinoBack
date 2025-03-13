package com.example.kinoback.ticket;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    //method to book a ticket in the database with a phone number
    public void bookTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }
}