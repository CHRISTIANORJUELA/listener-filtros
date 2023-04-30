package com.example.listeners_filters.services;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public interface WriteValueService<T>{
    void printMessage(T object, HttpServletResponse resp);

     void printError(HttpServletResponse resp,int numError, String message) throws IOException;

     void PrintList(List<T> list,HttpServletResponse response);
}
