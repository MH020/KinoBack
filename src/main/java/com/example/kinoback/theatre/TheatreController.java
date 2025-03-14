package com.example.kinoback.theatre;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:63343, http://localhost:63342, https://white-river-03715af10.6.azurestaticapps.net/")
@RequestMapping("/theatre")
public class TheatreController {
    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService){
        this.theatreService = theatreService;
    }
}
