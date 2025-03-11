package com.example.kinoback.movie;

import com.example.kinoback.actor.Actor;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63343")

@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping("/add")
    public void addMovie(@RequestBody Movie movie, List<Actor> actors) {
        System.out.print(movie);
    movieService.addMovie(movie,actors);
    }

}
