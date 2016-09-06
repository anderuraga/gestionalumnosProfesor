<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />

<c:set var="lista" value="${listadoAlumnos}"/>

<c:forEach items="${lista}" var="alumno">
<p>
<a href="alumnos/${alumno.codigo}">Codigo - ${alumno.codigo} Nombre - ${alumno.nombre}</a>
</p>
</c:forEach>

</body>
</html>