<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="${pageContext.request.contextPath}/hello-servlet">Probar listeners</a>
<br>
<a href="${pageContext.request.contextPath}/loginFilters.jsp">Logearme</a>
<br>
<a href="${pageContext.request.contextPath}/clave.html">Ver clave secreta (Probar antes de logearme para ver el filtro)</a>
<br>
<a href="${pageContext.request.contextPath}/baseData.jsp">Ir a base de datos</a>
</body>
</html>