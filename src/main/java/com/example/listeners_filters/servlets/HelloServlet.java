package com.example.listeners_filters.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Hello",value = {"/hello-servlet"})
public class HelloServlet extends HttpServlet {

    private final String user = "Maria";
    private final String passWord = "1";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String passWord = req.getParameter("password");
        if (this.user.equalsIgnoreCase(user)){
            if (this.passWord.equalsIgnoreCase(passWord)){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("user",user);
                httpSession.setAttribute("passWord",passWord);
                resp.sendRedirect("clave.html");
            }else {
                resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Contraseña Incorrecta");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Usuario Incorrecto");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        String context = (String) servletContext.getAttribute("mensaje");
        resp.getWriter().append("clave del context : ").append(context);
        String request = (String) req.getAttribute("mensaje");
        resp.getWriter().write("\n");
        resp.getWriter().append("clave request : ").append(request);
    }
}
