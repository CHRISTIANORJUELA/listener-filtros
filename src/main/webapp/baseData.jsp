<%@ page import="java.util.List" %>
<%@ page import="com.example.listeners_filters.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/25/2023
  Time: 9:22 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Base Data</title>
</head>
<body>
<%List<Product> productList = (List<Product>) request.getAttribute("list");%>
<div>
    <div>
        <h3>Buscar</h3>
        <form action="${pageContext.request.contextPath}/baseData" method="post">
            <input name="find_input" value="valor">
            <button type="submit">Enviar</button>
        </form>
    </div>
    <div>
        <h3>Agregar</h3>
        <form action="${pageContext.request.contextPath}/baseData" method="post">
            <input name="add_input" value="nombre">
            <input name="add_input" value="precio">
            <input name="add_input" value="fecha_registro">
            <input name="add_input" value="id_categoria">
            <button type="submit">Enviar</button>
        </form>
    </div>
    <div>
        <h3>Modificar</h3>
        <form action="${pageContext.request.contextPath}/baseData" method="post">
            <input name="update_input" value="id">
            <input name="update_input" value="valor a reemplazar">
            <button type="submit">Enviar</button>
        </form>
    </div>

    <div>
        <h3>Eliminar</h3>
        <form action="${pageContext.request.contextPath}/baseData" method="post">
            <input name="delete_input" value="valor">
            <button type="submit">Enviar</button>
        </form>
    </div>

    <div>
       <p>
           ¡id por defecto si no se ha alterado de otras Practicas!
           <br>
           id: 1,2,3
           <br>
           ¡id_categoria por defecto:
           <br>
           1,2,3
       </p>
    </div>
</div>
</body>
</html>
