package com.example.listeners_filters.services.impl;

import com.example.listeners_filters.exeptions.ServiceJdbcException;
import com.example.listeners_filters.models.Categoria;
import com.example.listeners_filters.models.Product;
import com.example.listeners_filters.services.Repository;
import com.example.listeners_filters.services.Service;
import com.example.listeners_filters.services.repository.CategoriaRepositorioImpl;
import com.example.listeners_filters.services.repository.ProductoRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class CategoriaServiceImpl implements Service<Categoria> {
    private Repository<Product> productRepository;
    private Repository<Categoria> categoryRepository;

    public CategoriaServiceImpl(Connection connection) {
        this.productRepository = new ProductoRepositoryImpl(connection);
        this.categoryRepository = new CategoriaRepositorioImpl(connection);
    }
    @Override
    public List<Categoria> listar() throws SQLException {
        try {
            return categoryRepository.listar();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),
                    throwables.getCause());
        }
    }

    @Override
    public Categoria findId(Long id){
        try{
            return categoryRepository.findId(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(String name, Double precio, LocalDate date, Integer id_categoria ) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }

    @Override
    public void Update(Long id,String newValue) {

    }
}
