package com.example.listeners_filters.servlets;

import com.example.listeners_filters.controllers.ConexionBaseDeDatos;
import com.example.listeners_filters.exeptions.ServiceJdbcException;
import com.example.listeners_filters.services.impl.ProductoServiceImpl;
import com.example.listeners_filters.utils.ActionBaseData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Optional;

@WebServlet(name = "baseData",value = {"/baseData"})
public class BaseDataServlet extends HttpServlet {

    ProductoServiceImpl productoServiceImpl;
    ActionBaseData actionBaseData;

    @Override
    public void init() throws ServletException {
        try {
            productoServiceImpl = new ProductoServiceImpl(ConexionBaseDeDatos.getConnection());
            actionBaseData = new ActionBaseData();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServiceJdbcException {
        Enumeration<String> enumeration = req.getParameterNames();
        String nameInput = "";
        Optional<String[]> values = Optional.empty();
        if (enumeration!=null){
            while (enumeration.hasMoreElements()){
                nameInput = enumeration.nextElement();
                values = Optional.ofNullable(req.getParameterValues(nameInput));
                break;
            }
        }
        try {
            String finalNameInput = nameInput;
            values.ifPresentOrElse(x->{
                actionBaseData.executeProcess(finalNameInput,x,req,resp,productoServiceImpl);
            },()->System.out.println("campo vacio"));
            /*
            if (!(req.getParameter(nameInput).equalsIgnoreCase(""))){
                System.out.println(Arrays.toString(req.getParameterValues(nameInput)));
                actionBaseData.executeProcess(nameInput,req,resp,productoServiceImpl);
            }else{
                System.out.println("campo vacio");
            }

             */
        }catch (NumberFormatException e) {
            System.out.println("campo vacio");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
