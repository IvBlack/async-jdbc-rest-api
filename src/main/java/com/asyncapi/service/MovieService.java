package com.asyncapi.service;

import org.springframework.stereotype.Service;

import com.asyncapi.dao.MovieDao;

import java.time.LocalDate;

@Service
public class MovieService {

    private final MovieDao movieDao;

    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
        public void deleteMovies(LocalDate inputDate) {
            this.movieDao.deleteMovies(inputDate);
        }
}
