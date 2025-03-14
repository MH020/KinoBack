package com.example.kinoback.movie;

import com.example.kinoback.actor.Actor;
import com.example.kinoback.showing.Showing;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.sql.Time;
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
    private String actorString;

    @OneToMany(mappedBy = "movie") //mapped by [table name]
    @JsonBackReference (value = "showings")
    private Set<Showing> showings = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Actor> actors = new HashSet<>();

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

    public Set<Showing> getShowings() {
        return showings;
    }

    public void setShowings(Set<Showing> showings) {
        this.showings = showings;
    }

    public String getActorString() {
        return actorString;
    }

    public void setActorString(String actorString) {
        this.actorString = actorString;
    }
}