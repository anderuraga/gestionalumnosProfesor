<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />

<c:set var="alumno" value="${alumno}" />

<form action="/formacion/alumnos" method="post">

  Codigo: <input type="text" name="codigo" value="${alumno.codigo}">
  Nombre: <input type="text" name="nombre" value="${alumno.nombre}">
  Nombre: <input type="text" name="apellidos" value="${alumno.apellidos}">
  <input type="submit" value="Update">
</form>

</body>
</html>
