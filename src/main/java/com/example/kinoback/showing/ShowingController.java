package com.example.kinoback.showing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showing")
public class ShowingController {
    private ShowingService showingService;

    public ShowingController(ShowingService showingService){
        this.showingService = showingService;
    }
}
