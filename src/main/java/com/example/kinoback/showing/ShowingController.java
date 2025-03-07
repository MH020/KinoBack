package com.example.kinoback.showing;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63343")
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
