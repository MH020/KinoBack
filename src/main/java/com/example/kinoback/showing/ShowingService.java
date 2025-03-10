package com.example.kinoback.showing;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowingService {
    private ShowingRepository showingRepository;

    public ShowingService(ShowingRepository showingRepository){
        this.showingRepository = showingRepository;
    }

    public List<Showing> getShowings() {
        return showingRepository.findAll();
    }

    public Optional<Showing> getChosenShowing(int id) {
        return showingRepository.findById(id);
    }
}
