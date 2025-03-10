package com.example.kinoback.movie;

import com.example.kinoback.actor.ActorMovie;
import com.example.kinoback.showing.Showing;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

enum Genres{
    HORROR, ROMANCE, ACTION, SCI_FI, DRAMA
}

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100)
    private String title;

    private int releaseYear;
    private Time duration;
    private int ageRestriction;
    private int genre;

    @Column(length = 100)
    private String director;

    @Column(length = 900)
    private String description;

    @OneToMany(mappedBy = "movie") //mapped by [table name]
    @JsonBackReference
    private Set<Showing> showings = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    @JsonBackReference
    private Set<ActorMovie> actorMovies = new HashSet<>();

    // getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}