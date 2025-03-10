package com.example.kinoback.movie;

import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }
}
