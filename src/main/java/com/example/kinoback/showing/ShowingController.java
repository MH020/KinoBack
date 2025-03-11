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

    @PostMapping("/create")
    public ResponseEntity<Showing> createShowing(@RequestBody Showing showing) {
        Showing newShowing = showingService.createShowing(showing);
        return ResponseEntity.ok(newShowing);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteShowing(@PathVariable int id) {
//        try {
//            showingService.deleteShowing(id);
//            return ResponseEntity.noContent().build();
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    //@GetMapping("/change/{id}")
}
