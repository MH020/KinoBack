package com.example.kinoback.controller;

import com.example.kinoback.movie.Movie;
import com.example.kinoback.movie.MovieController;
import com.example.kinoback.movie.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
public class MovieControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void testAddMovie_Success() throws Exception {

        // Arrange: Set up mock behavior
        Movie movie = new Movie();
        doNothing().when(movieService).save(any(Movie.class));

        // Act: Perform POST request to /movie/add endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/movie/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Inception\", \"director\": \"Christopher Nolan\"}"))

                // Assert: Verify response status
                .andExpect(status().isCreated());
    }

    @Test
    public void testAddMovie_Failure() throws Exception {

        // Arrange: Set up mock behavior to throw runtime exception
        doThrow(new RuntimeException("Service failure")).when(movieService).save(any(Movie.class));

        // Act: Perform POST request to /movie/add endpoint
        mockMvc.perform(MockMvcRequestBuilders.post("/movie/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Invalid Movie\", \"director\": \"Unknown\"}"))

                // Assert: Verify response status
                .andExpect(status().isInternalServerError());
    }

}