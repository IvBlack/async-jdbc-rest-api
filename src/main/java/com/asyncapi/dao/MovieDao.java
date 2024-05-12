package com.asyncapi.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieDao {

    boolean deleteMovies(LocalDate inputDate);
}
