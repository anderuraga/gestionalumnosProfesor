<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Página Inicio</title>
</head>
<body>
	<h1>Bienvenido a la aplicación de gestion de elementos</h1>
	<%
		List<Alumno> alumnos = (List<Alumno>) request.getAttribute("listado-alumnos");
		if (alumnos.size() > 0) {
			for (Alumno alumno : alumnos) {
				out.print("<p>" + alumno.getNombre() + " " + alumno.getApellidos() + "</p>");
	%>

	<%
		}
		}
		else {
	%>
	<p>No se han encontrado elementos en la BBDD</p>
	<%
		}
	%>

	<P>Hora local del servidor ${serverTime}.</P>
</body>
</html>
