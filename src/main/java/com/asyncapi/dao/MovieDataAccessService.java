package com.asyncapi.dao;

import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieDataAccessService implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //функция 
    @Override
    public boolean deleteMovies(LocalDate inputDate) {
        jdbcTemplate.execute((CallableStatementCreator) con -> {
            String storedProc = "{?=call batch_procedure()}"; // Called sql
            con.setAutoCommit(false); //This sentence is very important, no error
            CallableStatement cs = con.prepareCall(storedProc);
            cs.registerOutParameter(1, Types.OTHER);
            return cs;
        }, PreparedStatement::execute);
        return false;
    }
}
