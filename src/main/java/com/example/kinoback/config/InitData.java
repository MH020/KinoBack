package com.example.kinoback.config;

import com.example.kinoback.actor.Actor;
import com.example.kinoback.actor.ActorRepository;

import com.example.kinoback.movie.Movie;
import com.example.kinoback.movie.MovieRepository;
import com.example.kinoback.showing.Showing;
import com.example.kinoback.showing.ShowingRepository;
import com.example.kinoback.theatre.Theatre;
import com.example.kinoback.theatre.TheatreRepository;
import com.example.kinoback.ticket.Ticket;
import com.example.kinoback.ticket.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@Component
@Profile("test")
public class InitData implements CommandLineRunner {
    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    private TheatreRepository theatreRepository;
    private TicketRepository ticketRepository;
    private ShowingRepository showingRepository;


    public InitData(MovieRepository movieRepository, ActorRepository actorRepository, TheatreRepository theatreRepository, TicketRepository ticketRepository, ShowingRepository showingRepository){
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.theatreRepository =theatreRepository;
        this.ticketRepository = ticketRepository;
        this.showingRepository = showingRepository;

    }



    @Override
    public void run(String... args) throws Exception {
        // test 1
        Movie movie1 = new Movie();
        movie1.setDescription("movie 1 Description");
        movie1.setDirector("Director 1");
        movie1.setDuration(LocalTime.of(12, 0, 0));
        movie1.setGenre(1);
        movie1.setTitle("Terminator");
        movie1.setReleaseYear(1979);
        movie1.setAgeRestriction(18);
        movieRepository.save(movie1);

        Actor actor1 = new Actor();
        actor1.setFullName("Linda Hamilton");
        actorRepository.save(actor1);
        Actor actor2 = new Actor();
        actor2.setFullName("Arnold Schwarzenegger");
        actorRepository.save(actor2);

        Theatre theatre1 = new Theatre();
        theatre1.setSeats(100);
        theatreRepository.save(theatre1);


        Showing showing1 = new Showing();
        showing1.setDate(java.sql.Date.valueOf("2021-12-14"));
        showing1.setMovie(movie1);
        showing1.setTheatre(theatre1);
        showing1.setTime(LocalTime.of(12, 0, 0));
        showingRepository.save(showing1);


        Ticket ticket1 = new Ticket();
        ticket1.setPhoneNumber(12345678);
        ticket1.setShowing(showing1);
        ticketRepository.save(ticket1);

        // Test 2
        Movie movie2 = new Movie();
        movie2.setDescription("movie 2 Description");
        movie2.setDirector("Director 2");
        movie2.setDuration(LocalTime.of(12, 0, 0));
        movie2.setGenre(3);
        movie2.setTitle("Action Man");
        movie2.setReleaseYear(1984);
        movie2.setAgeRestriction(16);
        movieRepository.save(movie2);


        Theatre theatre2 = new Theatre();
        theatre1.setSeats(200);
        theatreRepository.save(theatre2);


        Showing showing2 = new Showing();
        showing2.setDate(java.sql.Date.valueOf("2021-12-14"));
        showing2.setMovie(movie2);
        showing2.setTheatre(theatre2);
        showing2.setTime(LocalTime.of(8, 0, 0));
        showingRepository.save(showing2);


        Ticket ticket2 = new Ticket();
        ticket2.setPhoneNumber(12345678);
        ticket2.setShowing(showing1);
        ticketRepository.save(ticket2);
    }
}
