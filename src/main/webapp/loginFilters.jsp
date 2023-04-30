<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/20/2023
  Time: 8:58 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filters</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/hello-servlet" method="post">
<div>
    <label for="username">Username</label>
    <div>
        <input type="text" name="username" id="username">
    </div>
</div>
<div>
    <label for="password">Password</label>
    <div>
        <input type="password" name="password" id="password">
    </div>
</div>
<div>
    <input type="submit" value="Login">
</div>
</form>
<div>
    <p>
        Usuario: Maria
        Clave : 1

    </p>
</div>
</body>
</html>
