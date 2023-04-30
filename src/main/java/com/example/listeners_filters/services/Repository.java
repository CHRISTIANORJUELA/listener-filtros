package com.example.listeners_filters.services;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T>{
    List<T> listar() throws SQLException;
    T findId(Long id) throws SQLException;
    void save(T t) throws SQLException;
    void delete(Long id) throws SQLException;

    void Update(Long id,String newValue);
}
