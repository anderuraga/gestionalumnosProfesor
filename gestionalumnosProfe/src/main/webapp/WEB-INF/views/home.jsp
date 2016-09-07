<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Página Inicio</title>
</head>
<body>
<h1>
	Bienvenido a la apliación de gestión de alumnos de Ipartek.
</h1>
<a href="alumnos">Alumnos</a>
<a href="cursos">Cursos</a>
<%
	List<Alumno> alumnos = (List<Alumno>)request.getAttribute("listado-alumnos");

	if(alumnos.size()>0){
		for(Alumno alumno: alumnos){
			out.println("<p>"+alumno.getNombre()+" "+alumno.getApellidos()+"</p>");
		}
	} else{
		%>
		<p>No se han encontrado alumnos en la BBDD.</p>
		<%
	}
%>

</body>
</html>
