package com.example.kinoback.movie;

import com.example.kinoback.actor.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private ActorRepository actorRepository;

    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository){
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    //This method adds a movie to the database and also adds the actors that are in the movie to the database
    public void save(Movie movie) {
       movieRepository.save(movie);
    }
}
