package com.example.kinoback.movie;

import com.example.kinoback.actor.Actor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping("/add")
    public void addMovie(Movie movie, List<Actor> actors) {
    movieService.addMovie(movie,actors);
    }

}
