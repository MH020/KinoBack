package com.example.kinoback.showing;

import com.example.kinoback.ticket.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowingService {
    private ShowingRepository showingRepository;

    public ShowingService(ShowingRepository showingRepository){
        this.showingRepository = showingRepository;
    }

    public List<Showing> getShowings() {
        return showingRepository.findAll();
    }

    //gets how many tickets a customer has ordered for a showing.
    public int getTicketsByPhoneNumber(int showingId, int phoneNumber){
        int ticketCounter = 0;

        List<Ticket> tickets = showingRepository.findAllTicketsForShowing(showingId); //find all tickets belonging to showing

        //verify ticket.phoneNumber equals customer phoneNumber
        for (Ticket ticket : tickets){
            if (ticket.getPhoneNumber() == phoneNumber){
                ticketCounter ++; //if true add 1 to counter.
            }
        }

        return ticketCounter;
    }
}
