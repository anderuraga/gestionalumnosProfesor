<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>

<%@page import="java.util.List"%>

<jsp:include page="../includes/header.jsp" />
<%
	List<Alumno> alumnos = (List<Alumno>) request.getAttribute("listado-alumnos");
		if (alumnos.size() > 0) {
	for (Alumno alumno : alumnos) {
		out.print("<p>" + alumno.getNombre() + " " + alumno.getApellidos()+ " " + alumno.getFechaNacimiento() + " <a href='alumnos/" + alumno.getCodigo() + "'><button type='button' class='btn btn-warning'>Modificar</button></a> <a href='#'><button type='button' class='btn btn-danger'>Eliminar</button></a></p>");
		
	}
		} else {
%>
<!-- Mensaje de tabla vacia -->
<p>No se han encontrado elementos en la BBDD</p>
<%
	}

		out.print("numero de alumnos "+ alumnos.size());
%>

</body>
</html>