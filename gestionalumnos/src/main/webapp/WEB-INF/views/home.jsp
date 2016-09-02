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
	Bienvenido a la aplicación de gestión de alumnos de Ipartek. 
</h1>

<%
	List<Alumno>alumnos=(List<Alumno>)request.getAttribute("listado-alumnos");
	if(alumnos!=null){
		for(Alumno alumno:alumnos){
			out.println("<p>"+alumno.getNombre()+" "+alumno.getApellidos()+"</p>");
		}
	}else{
		%>No se han encontrado alumnos en la base de datos.<%
	}
%>
</body>
</html>
