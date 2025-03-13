package com.example.kinoback.ticket;

import com.example.kinoback.movie.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63343, http://localhost:63342")
@RequestMapping("/ticket")
public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping("/all")
    public List<Ticket> allTickets(){
        return ticketService.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTicket(@RequestBody Ticket ticket) {
        System.out.print(ticket);
        ticketService.save(ticket);
    }
}
