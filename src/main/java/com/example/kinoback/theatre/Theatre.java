package com.example.kinoback.theatre;


import com.example.kinoback.showing.Showing;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int seats;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    //one theatre has many showings
    @OneToMany(mappedBy = "theatre") //mapped by [table name]
    @JsonBackReference
    private Set<Showing> showings = new HashSet<>();

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Set<Showing> getShowings() {
        return showings;
    }

    public void setShowings(Set<Showing> showings) {
        this.showings = showings;
    }


}
