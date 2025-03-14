package com.example.kinoback.ticket;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63343, http://localhost:63342")
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
    public void bookTicket(@RequestBody Ticket ticket) {
        ticketService.bookTicket(ticket);
    }
}