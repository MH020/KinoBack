package com.example.kinoback.showing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Showing> getChosenShowing(@PathVariable int id) {
        return showingService.getChosenShowing(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Showing> createShowing(@RequestBody Showing showing) {
        Showing newShowing = showingService.createShowing(showing);
        return ResponseEntity.ok(newShowing);
    }


    // Exception handler method to catch RuntimeExceptions thrown within controller
    @ExceptionHandler(RuntimeException.class)

   // Specifies the response status (500)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {

        // Returns ResponseEntity with HTTP 500 status and an error message in the response body
        // The error message includes the exception's message for debugging purposes
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
    }
}
