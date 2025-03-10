package com.example.kinoback.movie;

import com.example.kinoback.actor.Actor;
import com.example.kinoback.actor.ActorMovie;
import com.example.kinoback.actor.ActorMovieRepository;
import com.example.kinoback.actor.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    private ActorMovieRepository actorMovieRepository;

    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository, ActorMovieRepository actorMovieRepository){
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.actorMovieRepository = actorMovieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    //This method adds a movie to the database and also adds the actors that are in the movie to the database
    public void addMovie(Movie movie, List<Actor> actors) {
       for (Actor actor : actors) {
           ActorMovie actorMovie = new ActorMovie();
           actorMovie.setMovie(movie);
           actorMovie.setActor(actor);
           actorMovieRepository.save(actorMovie);
       }
       movieRepository.save(movie);
    }
}
