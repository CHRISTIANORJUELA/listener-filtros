package com.example.listeners_filters.services;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface WriteValueService<T>{
    void printMessage(T object, HttpServletResponse resp);

     void printError(HttpServletResponse resp,int numError, String message) throws IOException;
}
