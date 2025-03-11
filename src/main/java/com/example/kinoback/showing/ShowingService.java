package com.example.kinoback.showing;

import com.example.kinoback.ticket.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public int getTicketsByPhoneNumber(int showingId, long phoneNumber){
        int ticketCounter = 0;
        Optional<Showing> optionalShowing = showingRepository.findById(showingId); //get showing by showingId.

        if(optionalShowing.isPresent()){
            Showing showing = optionalShowing.get(); //get showing if optional not empty.

            System.out.println(showing.getTickets().size());

            for (Ticket ticket : showing.getTickets()){ //get tickets belonging to showing.
                if (ticket.getPhoneNumber() == phoneNumber){
                    ticketCounter ++; //if phonenumbers are equal, add 1 to ticketCounter.
                }
            }//end of for loop.

        }//end of if (optional)

        return ticketCounter;
    }
}
