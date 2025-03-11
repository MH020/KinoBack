package com.example.kinoback.ticket;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }


    public List<Ticket> getAllTickets (){
        return ticketRepository.findAll();
    }

}
