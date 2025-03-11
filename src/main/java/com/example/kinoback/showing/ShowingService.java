package com.example.kinoback.showing;

import com.example.kinoback.ticket.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingService {
    private ShowingRepository showingRepository;

    public ShowingService(ShowingRepository showingRepository){
        this.showingRepository = showingRepository;
    }

    public List<Showing> getShowings() {
        return showingRepository.findAll();
    }

    //Moving this calculation to Ticket domain.
    /*
    public int getTicketsByPhoneNumber(Showing showing, int phoneNumber){
        int ticketCounter = 0;
        for (Ticket ticket : Showing.getTickets()){
            if (ticket.getPhoneNumber() == phoneNumber){
                ticketCounter ++;
            }
        }
        return ticketCounter;
    }*/
}
