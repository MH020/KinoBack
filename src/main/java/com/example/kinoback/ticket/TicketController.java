package com.example.kinoback.ticket;
import com.example.kinoback.showing.Showing;
import com.example.kinoback.showing.ShowingController;
import com.example.kinoback.showing.ShowingRepository;
import com.example.kinoback.showing.ShowingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63343, http://localhost:63342, https://white-river-03715af10.6.azurestaticapps.net/")
@RequestMapping("/ticket")
public class TicketController {
    private final TicketRepository ticketRepository;
    private final ShowingRepository showingRepository;
    private TicketService ticketService;

    public TicketController(TicketService ticketService, TicketRepository ticketRepository, ShowingRepository showingRepository){
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;
        this.showingRepository = showingRepository;
    }

    @GetMapping("/allTickets")
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    //method to book a ticket in the database with a phone number
    @PostMapping("/book")
    public void bookTicket(@RequestBody String json) {
        json = json.trim().substring(1, json.length() - 1);
        String[] parts = json.split(",");

        int showingId = Integer.parseInt(parts[0].split(":")[1].trim().replace("\"", ""));
        long phoneNumber = Long.parseLong(parts[1].split(":")[1].trim().replace("\"", ""));

        Showing showing = showingRepository.findById(showingId).get();
        Ticket ticketToBook = new Ticket(showing, phoneNumber);
        ticketService.bookTicket(ticketToBook);
    }
}