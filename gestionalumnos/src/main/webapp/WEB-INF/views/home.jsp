<%@page import="com.ipartek.formacion.dao.persistencia.Alumno" %>
<%@page import="com.ipartek.formacion.dao.persistencia.Curso" %>
<%@page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Página Inicio</title>
</head>
<body>
<h1>
	Bienvenido a la aplicación de gestión de alumnos de Ipartek.
</h1>

<%
	List<Alumno> alumnos = (List<Alumno>) request.getAttribute("listado-alumnos");

		if(alumnos.size() > 0){
			for(Alumno alumno: alumnos){
				out.print("<p>" + alumno.getNombre() + " " + alumno.getApellidos() + "</p>");
			
			}
		}
		else{
		%>
			<p>No se han encontrado alumnos en la BBDD.</p>
		<%
		}
		
		List<Curso> cursos = (List<Curso>) request.getAttribute("listado-cursos");

		if(cursos.size() > 0){
			for(Curso curso: cursos){
				out.print("<p>" + curso.getNombre() + "</p>");
			
			}
		}
		else{
		%>
			<p>No se han encontrado cursos en la BBDD.</p>
		<%
		}
%>
</body>
</html>
