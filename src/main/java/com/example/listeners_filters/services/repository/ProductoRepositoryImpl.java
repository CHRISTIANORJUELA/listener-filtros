package com.example.listeners_filters.services.repository;

import com.example.listeners_filters.controllers.ConexionBaseDeDatos;
import com.example.listeners_filters.models.Product;
import com.example.listeners_filters.services.Repository;
import com.example.listeners_filters.utils.CreateProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryImpl implements Repository<Product> {
    private Connection conn;
    public ProductoRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    public List<Product> listar() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p inner join categorias as c on(p.id_categorias=c.id)\" +\"ORDER BY p.ID ASC")) {
             while (rs.next()) {
                 Product p = CreateProduct.createProduct(rs);
                 products.add(p);
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product findId(Long id) throws SQLException {
        Product product = null;
        try (PreparedStatement preparedStatement = ConexionBaseDeDatos.getConnection().prepareStatement("SELECT * FROM productos where id =?")){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                product = CreateProduct.createProduct(resultSet);
            }
            resultSet.close();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void save(Product product) throws SQLException {
        String sentencia = "INSERT INTO productos(nombre,precio,fecha_registro,id_categorias) values(?,?,?,?)";
        try (PreparedStatement preparedStatement = ConexionBaseDeDatos.getConnection().prepareStatement(sentencia)){
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDate(3, Date.valueOf(product.getDate()));
            preparedStatement.setInt(4,product.getCategoria_id());
            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        try (PreparedStatement preparedStatement = ConexionBaseDeDatos.getConnection().prepareStatement("DELETE from productos where id = ?")){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Long id,String newValue){
        try (PreparedStatement preparedStatement = ConexionBaseDeDatos.getConnection().prepareStatement("UPDATE productos set nombre = ? where id = ?")){
            preparedStatement.setString(1,newValue);
            preparedStatement.setLong(2,id);
            preparedStatement.execute();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
