package com.example.kinoback.showing;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Showing createShowing(Showing showing) {
        return showingRepository.save(showing);
    }

//    public void deleteShowing(int id) {
//        if (showingRepository.existsById(id)) {
//            showingRepository.deleteById(id);
//        } else {
//            throw new IllegalArgumentException("Showing with ID " + id + " does not exist.");
//        }
//    }
}