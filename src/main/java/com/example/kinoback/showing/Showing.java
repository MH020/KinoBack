package com.example.kinoback.showing;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Showing {
    @Id
    private int id;
    private Time time;
    private Date date;

    
    private int movieId;
    private int theatreId;

}
