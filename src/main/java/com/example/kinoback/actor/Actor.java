package com.example.kinoback.actor;
import jakarta.persistence.*;

@Entity
public class Actor {
    @Id
   private int id;

    @Column(length = 100)
  private String fullName;

    @OneToMany
    @JoinColumn(name = "ActorMovie", referencedColumnName = "");
    private int actorId;


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

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
}

