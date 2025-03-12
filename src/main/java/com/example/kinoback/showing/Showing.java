package com.example.kinoback.showing;

import com.example.kinoback.movie.Movie;
import com.example.kinoback.theatre.Theatre;
import com.example.kinoback.ticket.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Time time;
    private Date date;

    //many showings of one movie
    @ManyToOne
    @JoinColumn(name = "movieId", referencedColumnName = "id") //name = name of attribute, referencedColumnName = id on movie-object.
    private Movie movie;

    //many showings in one theatre
    @ManyToOne
    @JoinColumn(name = "theatreId", referencedColumnName = "id")
    private Theatre theatre;

    //one showing has many tickets.
    @OneToMany(mappedBy = "showing")
    @JsonBackReference (value = "tickets") //set jsonbackreference name = showing
    private Set<Ticket> tickets = new HashSet<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }


}
