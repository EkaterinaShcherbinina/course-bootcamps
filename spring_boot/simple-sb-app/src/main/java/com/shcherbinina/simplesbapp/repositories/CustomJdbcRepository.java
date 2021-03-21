package com.shcherbinina.simplesbapp.repositories;

public interface CustomJdbcRepository<T> {
    T customerById(int id);
}
