<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />

<c:set var="lista" value="${listadoAlumnos}"/>
<p>
<a href="alumnos/addAlumno">Crear Alumno</a>
</p>
<c:forEach items="${lista}" var="alumno">
<div>
<a href="alumnos/${alumno.codigo}">Codigo - ${alumno.codigo} Nombre - ${alumno.nombre}</a>
</div>
</c:forEach>

</body>
</html>