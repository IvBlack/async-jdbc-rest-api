package com.asyncapi.service;

import org.springframework.stereotype.Service;

import com.asyncapi.dao.MovieDao;
import com.asyncapi.exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieDao movieDao;

    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

        public void deleteMovies(LocalDate input_date) {
            Boolean result = movieDao.deleteMovies(input_date);
            if (!result) {
                throw new IllegalStateException("oops could not delete movie");
            }
    }
}
