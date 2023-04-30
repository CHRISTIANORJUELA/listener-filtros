<%--
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
<div>
    <div>
        <form action="${pageContext.request.contextPath}/baseData" method="post">
            <input name="find_input" value="valor">
            <button type="submit">Enviar</button>
        </form>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/baseData" method="post">
            <input name="add_input" value="nombre">
            <input name="add_input" value="precio">
            <input name="add_input" value="fecha_registro">
            <input name="add_input" value="id_categoria">
            <button type="submit">Enviar</button>
        </form>
    </div>
    <div>
        <form action="${pageContext.request.contextPath}/baseData" method="post">
            <input name="update_input" value="valor">
            <button type="submit">Enviar</button>
        </form>
    </div>

    <div>
        <form action="${pageContext.request.contextPath}/baseData" method="post">
            <input name="delete_input" value="valor">
            <button type="submit">Enviar</button>
        </form>
    </div>
</div>
</body>
</html>
