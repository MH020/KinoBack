package com.example.kinoback.showing;

import com.example.kinoback.movie.Movie;
import com.example.kinoback.theatre.Theatre;
import com.example.kinoback.ticket.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
public class Showing {
    @Id
    private int id;
    private Time time;
    private Date date;

    private int movieId;

    @ManyToOne
    @JoinColumn(name = "movieId", referencedColumnName = "id") //name = name of attribute, referencedColumnName = id on movie-object.
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theatreId", referencedColumnName = "id")
    private Theatre theatre;

    @OneToMany(mappedBy = "showing")
    @JsonBackReference
    private Set<Ticket> tickets;


}
