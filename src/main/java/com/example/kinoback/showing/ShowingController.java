package com.example.kinoback.showing;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Showing> getChosenShowing(@PathVariable int id) {
        return showingService.getChosenShowing(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //@GetMapping("/delete/{id}")

    //@GetMapping("/change/{id}")

    //@GetMapping("/createShowing")

}
