package com.asyncapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import com.asyncapi.service.MovieService;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;


/*
    На уровне контроллера можно гибко управлять асинхронным поведением методов,
    добавляя @Async("asyncTaskExecutor") к вызову, если это необходимо.
*/
@Slf4j
@RestController
@RequestMapping(path = "api/v1/movies/{date:[0-9]{4}-[0-9]{2}-[0-9]{2}}")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Async("asyncTaskExecutor")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public CompletableFuture<ResponseEntity<Void>> deleteMovie(@PathVariable("date") LocalDate date) {
        this.movieService.deleteMovies(date);
        return CompletableFuture.completedFuture(ResponseEntity.noContent()
                .build());
    }
}
