package com.asyncapi.mapper;

import org.springframework.jdbc.core.RowMapper;

import com.asyncapi.dao.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MovieRowMapper implements RowMapper<Movie> {
    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Movie(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                LocalDate.parse(resultSet.getString("release_date"))
        );
    }
}
