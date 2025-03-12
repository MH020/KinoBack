package com.example.kinoback.movie;

import com.example.kinoback.actor.ActorMovie;
import com.example.kinoback.showing.Showing;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalTime;
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
    private LocalTime duration;
    private int ageRestriction;
    private int genre;

    @Column(length = 100)
    private String director;
    @Column(length = 900)
    private String description;

    @OneToMany(mappedBy = "movie") //mapped by [table name]
    @JsonBackReference (value = "showings")
    private Set<Showing> showings = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference (value = "movie")
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

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}