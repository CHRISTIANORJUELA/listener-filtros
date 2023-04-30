package com.example.listeners_filters.services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface Service <T>{
    List<T> listar() throws SQLException;
    T findId(Long id) throws SQLException;
    void save(String name, Double precio, LocalDate date, Integer id_categoria ) throws SQLException;
    void delete() throws SQLException;
    void Update();
}
