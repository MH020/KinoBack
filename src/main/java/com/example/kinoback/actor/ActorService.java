package com.example.kinoback.actor;

import org.springframework.stereotype.Service;

@Service
public class ActorService {
    private ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }
}
