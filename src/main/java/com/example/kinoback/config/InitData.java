package com.example.kinoback.config;

import com.example.kinoback.actor.Actor;
import com.example.kinoback.actor.ActorMovie;
import com.example.kinoback.actor.ActorMovieRepository;
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

import java.sql.Time;
@Component
@Profile("test")
public class InitData implements CommandLineRunner {
    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    private TheatreRepository theatreRepository;
    private TicketRepository ticketRepository;
    private ShowingRepository showingRepository;
    private ActorMovieRepository actorMovieRepository;

    public InitData(MovieRepository movieRepository, ActorRepository actorRepository, TheatreRepository theatreRepository, TicketRepository ticketRepository, ShowingRepository showingRepository, ActorMovieRepository actorMovieRepository){
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.theatreRepository =theatreRepository;
        this.ticketRepository = ticketRepository;
        this.showingRepository = showingRepository;
        this.actorMovieRepository = actorMovieRepository;

    }



    @Override
    public void run(String... args) throws Exception {
        Movie movie1 = new Movie();
        movie1.setDescription("movie 1 Description");
        movie1.setDirector("Director 1");
        movie1.setDuration(Time.valueOf("01:45:00"));
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

        ActorMovie actorMovie = new ActorMovie();
        actorMovie.setActor(actor1);
        actorMovie.setMovie(movie1);
        actorMovieRepository.save(actorMovie);



        Theatre theatre1 = new Theatre();
        theatre1.setSeats(100);
        theatreRepository.save(theatre1);


        Showing showing1 = new Showing();
        showing1.setDate(java.sql.Date.valueOf("2021-12-12"));
        showing1.setMovie(movie1);
        showing1.setTheatre(theatre1);
        showing1.setTime(Time.valueOf("12:00:00"));
        showingRepository.save(showing1);


        Ticket ticket1 = new Ticket();
        ticket1.setPhoneNumber(12345678);
        ticket1.setShowing(showing1);
        ticketRepository.save(ticket1);
    }
}
