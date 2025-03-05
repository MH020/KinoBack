package com.example.kinoback.actor;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Actor {
    @Id
   private int id;

    @Column(length = 100)
  private String fullName;

    @OneToMany(mappedBy = "Actor")
    @JsonBackReference
    private Set<ActorMovie> actorMovies = new HashSet<>();


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

