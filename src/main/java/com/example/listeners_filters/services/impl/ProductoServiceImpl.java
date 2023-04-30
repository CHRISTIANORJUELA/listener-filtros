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

public class ProductoServiceImpl implements Service<Product>{
    private Repository<Product> productRepository;
    private Repository<Categoria> categoryRepository;

    public ProductoServiceImpl(Connection connection) {
        this.productRepository = new ProductoRepositoryImpl(connection);
        this.categoryRepository = new CategoriaRepositorioImpl(connection);
    }

    @Override
    public List<Product> listar() throws SQLException {
        try {
            return productRepository.listar();
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),
                    throwables.getCause());
        }
    }

    @Override
    public Product findId(Long id) throws SQLException {
        try {
            return productRepository.findId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(String name, Double precio, LocalDate date, Integer id_categoria ) throws SQLException {
        try {
            productRepository.save(new Product(name,precio,date,id_categoria));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
      try {
          productRepository.delete(id);
      }catch (SQLException e){
          e.printStackTrace();
      }
    }

    @Override
    public void Update(Long id,String newValue) {
        productRepository.Update(id,newValue);
    }

}
