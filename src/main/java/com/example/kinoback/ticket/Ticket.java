package com.example.kinoback.ticket;

import com.example.kinoback.showing.Showing;
import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long phoneNumber;

    //many tickets to one showing
    @ManyToOne
    @JoinColumn(name = "showingId", referencedColumnName = "id")
    private Showing showing;

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // skal de 2 sidste være der??
    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }
}