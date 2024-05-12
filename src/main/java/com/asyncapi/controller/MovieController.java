package com.asyncapi.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import com.asyncapi.service.MovieService;

import java.time.LocalDate;


/*
    На уровне контроллера можно гибко управлять асинхронным поведением методов,
    добавляя @Async("asyncTaskExecutor") к вызову, если это необходимо.
*/
@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Async("asyncTaskExecutor")
    @DeleteMapping("{date}")
    public void deleteMovie(@PathVariable("date") LocalDate input_date) {
        movieService.deleteMovies(input_date);
    }
    
    /* 
    Для примера добавлен асинхронный метод удаления строки по идентификатору:

    @Async("asyncTaskExecutor")
    @DeleteMapping("{id}")
    public void deleteMovie(@PathVariable("id") Integer id) {
        movieService.deleteMovie(id);
    }

     * 
     * 
     * 
    */
}
