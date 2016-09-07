<%@page import="com.ipartek.formacion.dao.persistence.Modulo"%>
<%@page import="com.ipartek.formacion.dao.persistence.Curso"%>
<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>

	<head>
		<title>Pagina Inicio</title>
	</head>
	
	<body>
		<h1>
			Bienvenido a la aplicacion de Gestion de Alumnos de Ipartek. 
		</h1>
		
		<p>
			<a href="cursos">Cursos</a>
			<a href="alumnos">Alumnos</a>
			<a href="modulos">Modulos</a>
		</p>
		
		<a href="alumnos/addAlumno">Crear Alumno</a>
		
	</body>

</html>
