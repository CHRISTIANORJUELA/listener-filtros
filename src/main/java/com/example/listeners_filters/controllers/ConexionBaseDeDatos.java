package com.example.listeners_filters.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
    private static String url = "jdbc:mysql://127.0.0.1:3307/practicas";

    private static String root = "root";
    private static String passWord = "sql1234";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,root,passWord);
    }

}
