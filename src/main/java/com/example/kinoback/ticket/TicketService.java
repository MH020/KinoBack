package com.example.kinoback.ticket;

import com.example.kinoback.showing.Showing;
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
        Showing showing = ticket.getShowing();

        int availableSeats = showing.getTheatre().getSeats();
        if(availableSeats < 0) {
            showing.getTheatre().setSeats(availableSeats - 1);
            ticketRepository.save(ticket);

        } else {
            throw new RuntimeException("No available seats");
        }
    }
}