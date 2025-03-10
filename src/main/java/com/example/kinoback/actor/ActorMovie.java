package com.example.kinoback.actor;

import com.example.kinoback.movie.Movie;
import jakarta.persistence.*;

@Entity
public class ActorMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "actorId", referencedColumnName = "id") //name = name of attribute, referencedColumnName = id on movie-object.
    private Actor actor;

    // en film har mange ActorMovies så derfor er dette en many to one
    @ManyToOne
    @JoinColumn(name = "movieId",referencedColumnName = "id")
    private Movie movie;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
