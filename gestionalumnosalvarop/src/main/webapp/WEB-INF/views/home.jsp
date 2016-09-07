<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Formacion ipartek</title>
</head>
<body>
<h1>
	Bienvenido a la aplicaci�n de gesti�n de alumnos de Ipartek. 
</h1>

<nav class="navbar navbar-dark bg-warning">
  <div class="nav navbar-nav">
    <a class="nav-item nav-link active" href="alumnos">Listado Alumnos <span class="sr-only"></span></a>
    <a class="nav-item nav-link" href="cursos">Listado cursos</a>
    <a class="nav-item nav-link" href="modulos">Listado modulos</a>
  </div>
</nav>




<a href="alumnos/addAlumno">Crear alumno</a>
<%
	List<Alumno>alumnos=(List)request.getAttribute("listado-alumnos");
		if(alumnos.size()>0){
			
			for(Alumno alumno: alumnos){
			out.print("<p>"+alumno.getNombre()+" " +alumno.getApellidos() +"</p>");
			}
		}
		else{
			%>
			No se han encontrado alumnos en la base de datos.
			<%
		}
%>




<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
