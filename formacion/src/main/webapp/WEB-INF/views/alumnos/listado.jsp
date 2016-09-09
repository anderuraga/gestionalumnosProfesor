<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Alumnos</title>
</head>
<body>

		<a href="home">Inicio</a>
		
		<a href="alumnos/addAlumno">Crear Alumno</a>

		<p><b>Listado de Alumnos:</b></p>
		
		<%
			List<Alumno> alumnos = (List<Alumno>) request.getAttribute("listado-alumnos");
			if(alumnos.size()>0){
				for(Alumno alumno: alumnos){
					out.print("<p><a href='alumnos/" + alumno.getCodigo() + "'>" + alumno.getNombre() + " " + alumno.getApellidos() + "</a> <b><a href='alumnos/delete/" + alumno.getCodigo() + "'>Borrar Alumno</a></b></p>");
				}
			} else{
				%>
					<p>No se han encontrado alumnos en la Base de Datos.</p>
				<%
			}
		%>

</body>
</html>