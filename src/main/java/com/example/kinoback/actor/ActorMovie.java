package com.example.kinoback.actor;

import com.example.kinoback.movie.Movie;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class ActorMovie {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "actorId", referencedColumnName = "id") //name = name of attribute, referencedColumnName = id on movie-object.
    private Actor actor;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
