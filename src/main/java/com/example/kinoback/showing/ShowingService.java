package com.example.kinoback.showing;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingService {
    private ShowingRepository showingRepository;

    public ShowingService(ShowingRepository showingRepository){
        this.showingRepository = showingRepository;
    }

    public List<Showing> getShowings() {
        return showingRepository.findAll();
    }
}
