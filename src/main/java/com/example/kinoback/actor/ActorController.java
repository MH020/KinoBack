package com.example.kinoback.actor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63343, http://localhost:63342https://white-river-03715af10.6.azurestaticapps.net/")
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
