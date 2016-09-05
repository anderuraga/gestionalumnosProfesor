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
			<a href="/cursos/listado.jsp">Cursos</a>
			<a href="/alumnos/listado.jsp">Alumnos</a>
			<a href="/modulos/listado.jsp">Modulos</a>
		</p>
		
		<p><b>Listado de Alumnos:</b></p>
		
		<%
			List<Alumno> alumnos = (List<Alumno>) request.getAttribute("listado-alumnos");
			if(alumnos.size()>0){
				for(Alumno alumno: alumnos){
					out.print("<p>" + alumno.getNombre() + " " + alumno.getApellidos() + "</p>");
				}
			} else{
				%>
					<p>No se han encontrado alumnos en la Base de Datos.</p>
				<%
			}
		%>
		
		<p><b>Listado de Cursos:</b></p>
		
		<%
			List<Curso> cursos = (List<Curso>) request.getAttribute("listado-cursos");
			if(cursos.size()>0){
				for(Curso curso: cursos){
					out.print("<p>" + curso.getNombre() + "</p>");
				}
			} else{
				%>
					<p>No se han encontrado cursos en la Base de Datos.</p>
				<%
			}
		%>
		
	</body>

</html>
