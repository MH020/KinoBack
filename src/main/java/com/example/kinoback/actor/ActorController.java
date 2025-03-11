package com.example.kinoback.actor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private ActorService actorService;

    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }

    @GetMapping("/all")
    public List<Actor> getActors() {
        return actorService.getActors();
    }
    

}
