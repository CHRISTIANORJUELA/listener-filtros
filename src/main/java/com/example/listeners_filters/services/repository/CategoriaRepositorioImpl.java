package com.example.listeners_filters.services.repository;

import com.example.listeners_filters.controllers.ConexionBaseDeDatos;
import com.example.listeners_filters.models.Categoria;
import com.example.listeners_filters.models.Product;
import com.example.listeners_filters.services.Repository;
import com.example.listeners_filters.utils.CreateProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements Repository<Categoria> {
    Connection connection;
    public CategoriaRepositorioImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> products = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p inner join categorias as c on(p.id_categorias=c.id)\" +\"ORDER BY p.ID ASC")) {
            while (rs.next()) {
                Categoria p = CreateProduct.createCategoria(rs);
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Categoria findId(Long id) throws SQLException {
        Categoria categoria = null;
        try (PreparedStatement preparedStatement = ConexionBaseDeDatos.getConnection().prepareStatement("SELECT * FROM categorias where id =?")){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                categoria = CreateProduct.createCategoria(resultSet);
            }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return categoria;
    }

    @Override
    public void save(Categoria categoria) throws SQLException {

    }

    @Override
    public void delete(Long id) throws SQLException {

    }

    @Override
    public void Update(Long id, String newValue) {

    }
}
