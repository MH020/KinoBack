package com.example.kinoback.theatre;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService){
        this.theatreService = theatreService;
    }
}
