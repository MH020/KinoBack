package com.example.kinoback.config;

import com.example.kinoback.actor.Actor;
import com.example.kinoback.actor.ActorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class ActorTest {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorTest(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @PostConstruct
    public void init() {
        // initialiser testData her
        Actor actor1 = new Actor();
        actor1.setFullName("John Doe");

        Actor actor2 = new Actor();
        actor2.setFullName("Jane Smith");

        // Gemmer testData i databasen
        actorRepository.save(actor1);
        actorRepository.save(actor2);


        System.out.println("Test data initialized for Actor");
    }
}
