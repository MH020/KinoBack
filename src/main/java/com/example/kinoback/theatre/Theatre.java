package com.example.kinoback.theatre;


import com.example.kinoback.showing.Showing;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Theatre {

    @Id
    private int id;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @OneToMany(mappedBy = "theatre") //mapped by [table name]
    @JsonBackReference
    private Set<Showing> showings = new HashSet<>();



}
