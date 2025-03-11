package com.example.kinoback.controller;

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
@WebMvcTest(ShowingController.class)
public class ShowingControllerUnitTest {

    // Injects MockMvc instance used to simulate HTTP requests and test controller
    @Autowired
    private MockMvc mockMvc;

    // Creates mock bean for service class to simulate its behavior
    @MockBean
    private ShowingService showingService;

    // Tests successful retrieval of showings
    @Test
    public void testGetShowings_Success() throws Exception {

        // Arrange: Set up mock behavior to return list of two showings
        when(showingService.getShowings()).thenReturn(Arrays.asList(new Showing(), new Showing()));

        // Act: Perform GET request to the /showing/all endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/showing/all"))

                // Assert: Verify that the response status is 200 OK
                .andExpect(status().isOk())
                // Assert: Verify that the JSON response contains two elements
                .andExpect(jsonPath("$.size()").value(2));
    }

    // Tests handling a failure scenario when service layer throws exception
    @Test
    public void testGetShowings_Failure() throws Exception {

        // Arrange: Set up mock service to throw a RuntimeException
        when(showingService.getShowings()).thenThrow(new RuntimeException("Service failure"));

        // Act: Perform GET request to the /showing/all endpoint
        mockMvc.perform(MockMvcRequestBuilders.get("/showing/all"))

                // Assert: Verify that the response status is 500 Internal Server Error
                .andExpect(status().isInternalServerError());
    }

}