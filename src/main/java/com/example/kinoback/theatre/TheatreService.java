package com.example.kinoback.theatre;

import org.springframework.stereotype.Service;

@Service
public class TheatreService {
    private TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository){
        this.theatreRepository = theatreRepository;
    }
}
