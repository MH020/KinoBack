package com.example.kinoback.showing;

import org.springframework.stereotype.Service;

@Service
public class ShowingService {
    private ShowingRepository showingRepository;

    public ShowingService(ShowingRepository showingRepository){
        this.showingRepository = showingRepository;
    }
}
