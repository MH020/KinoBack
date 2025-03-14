package com.example.kinoback.showing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63343, http://localhost:63342, https://white-river-03715af10.6.azurestaticapps.net/")
@RequestMapping("/showing")
public class ShowingController {
    private ShowingService showingService;

    public ShowingController(ShowingService showingService){
        this.showingService = showingService;
    }
    
    @GetMapping("/all")
    public List<Showing> getShowings() {
        return showingService.getShowings();
    }
}
