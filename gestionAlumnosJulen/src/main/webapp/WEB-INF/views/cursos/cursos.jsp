<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />

<c:set var="curso" value="${curso}" />

<form action="/formacion/cursos" method="POST">
  Codigo: <input type="text" name="codigo" value="${curso.codigo}">
  Nombre: <input type="text" name="nombre" value="${curso.nombre}">
  <input type="submit" value="Update">
</form>

</body>
</html>