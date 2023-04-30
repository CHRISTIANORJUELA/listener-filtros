package com.example.listeners_filters.utils;

import com.example.listeners_filters.models.Categoria;
import com.example.listeners_filters.models.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateProduct<T> {
    public static Product createProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("nombre"));
        product.setPrice(resultSet.getDouble("precio"));
        product.setDate(resultSet.getDate("fecha_registro").toLocalDate());
        return product;
    }

    public static Categoria createCategoria(ResultSet resultSet) throws SQLException {
        Categoria categoria = new Categoria(resultSet.getLong("id"),resultSet.getString("nombre"));
        return categoria;
    }
}
