package com.amigoscode.movie;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import com.asyncapi.controller.MovieController;
import com.asyncapi.service.MovieService;

class MovieControllerTest {

    @Mock
    private MovieService movieService;

    private MovieController underTest;

    @BeforeEach
    void setUp() {
        underTest = new MovieController(movieService);
    }
}