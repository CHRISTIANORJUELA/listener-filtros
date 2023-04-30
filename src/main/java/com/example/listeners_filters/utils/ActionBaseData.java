package com.example.listeners_filters.utils;

import com.example.listeners_filters.models.Product;
import com.example.listeners_filters.services.WriteValueService;
import com.example.listeners_filters.services.impl.ProductoServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ActionBaseData implements WriteValueService<Product> {

    public void executeProcess(String nameInput,String[] values,HttpServletRequest req, HttpServletResponse res, ProductoServiceImpl productoServiceImpl){
       try {
           switch (nameInput){
               case "find_input":
                       Long id = Long.valueOf(req.getParameter("find_input"));
                       Optional<Product> product = Optional.ofNullable(productoServiceImpl.findId(id));
                       product.ifPresentOrElse(x-> printMessage(x,res),()-> printError(res,404,"Producto no encontrado"));
                   break;
               case "add_input":
                   if (Comprobate.verifyValuesInParameter(values)){
                       printError(res,406,"No has rellenado todos los valores para comenzar la busqueda");
                   }else {
                       productoServiceImpl.save(values[0],Double.valueOf(values[1]), LocalDate.parse(values[2]),Integer.valueOf(values[3]));
                       PrintList(productoServiceImpl.listar(),res);
                       System.out.println("------Guardado exitosamente----");
                   }
                   break;
               case "update_input":
                   if (Comprobate.verifyValuesInParameter(values)){
                       printError(res,406,"No has rellenado todos los valores para comenzar la busqueda");
                   }else {
                       productoServiceImpl.Update(Long.valueOf(values[0]),values[1]);
                       PrintList(productoServiceImpl.listar(),res);
                       System.out.println("------Actualizado exitosamente----");
                   }
                   break;
               case "delete_input":
                   productoServiceImpl.delete(Long.valueOf(values[0]));
                   PrintList(productoServiceImpl.listar(),res);
                   System.out.println("------Eliminado exitosamente----");
                   break;
               default:
                   break;
           }
       }catch (SQLException e){

       }

    }

    @Override
    public void printMessage(Product x,HttpServletResponse resp){
        try {
            resp.getWriter().write(x.toString());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void PrintList(List<Product> list, HttpServletResponse response){
            list.forEach(x->{
                try {
                    response.getWriter().write(x.toString());
                    response.getWriter().write("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

    }
    @Override
    public void printError(HttpServletResponse resp,int numError,String message){
        try {
            resp.sendError(numError,message);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
