package com.asyncapi.dao;

import java.time.LocalDate;

public record Movie(Integer id,
                    String name,
                    LocalDate releaseDate) {
}
