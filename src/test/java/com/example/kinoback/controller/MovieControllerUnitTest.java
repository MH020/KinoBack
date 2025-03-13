package com.example.kinoback.controller;

import com.example.kinoback.movie.Movie;
import com.example.kinoback.movie.MovieController;
import com.example.kinoback.movie.MovieService;
import com.example.kinoback.showing.Showing;
import com.example.kinoback.showing.ShowingController;
import com.example.kinoback.showing.ShowingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Marking test as a Spring Web Mvc test
@WebMvcTest(MovieController.class)
public class MovieControllerUnitTest {

    // Injects MockMvc instance used to simulate HTTP requests and test controller
    @Autowired
    private MockMvc mockMvc;

    // Creates mock bean for service class to simulate its behavior
    @MockBean
    private MovieService movieService;

    // Tests successful retrieval of showings
    @Test
    public void testGetMovies_Success() throws Exception {

        // Arrange: Set up mock behavior to return list of three movies
        when(movieService.getMovies()).thenReturn(Arrays.asList(new Movie(), new Movie(), new Movie()));

        // Act: Perform GET request to the /movie/all endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/all"))

                // Assert: Verify that the response status is 200 OK
                .andExpect(status().isOk())
                // Assert: Verify that the JSON response contains two elements
                .andExpect(jsonPath("$.size()").value(3));
    }

    // Tests handling a failure scenario when service layer throws exception
    @Test
    public void testGetMovies_Failure() throws Exception {

        // Arrange: Set up mock service to throw a RuntimeException
        when(movieService.getMovies()).thenThrow(new RuntimeException("Service failure"));

        // Act: Perform GET request to the /movie/all endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/movie/all"))

                // Assert: Verify that the response status is 500 Internal Server Error
                .andExpect(status().isInternalServerError());
    }

}