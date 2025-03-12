package com.example.kinoback.ticket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketRepository ticketRepository;
    private TicketService ticketService;

    public TicketController(TicketService ticketService, TicketRepository ticketRepository){
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/allTickets")
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    //method to book a ticket in the database with a phone number
    @PostMapping("/book")
    public void bookTicket(Ticket ticket, List<Ticket> tickets) {
        ticketService.bookTicket(ticket, tickets);
    }
}