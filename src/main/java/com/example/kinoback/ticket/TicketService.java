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
    public void bookTicket(Ticket ticket, List<Ticket> tickets) {
        for (Ticket ticket1 : tickets) {
            ticket1.setPhoneNumber(ticket.getPhoneNumber());
            ticketRepository.save(ticket1);
        }
        ticketRepository.save(ticket);
    }
}