<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Pagina de Inicio</title>
</head>
<body>
<h1>
	Bienvenido a la aplicación de gestión de alumnos de Ipartek.
</h1>

<%
	List<Alumno> alumnos = (List<Alumno>)request.getAttribute("listado-alumnos");
	if(alumnos.size()>0){
	  for(Alumno a : alumnos){
	    out.print("<p>"+a.getNombre()+" "+a.getApellidos()+"</p>");
	    
	  } 
	}else{
	  %>
	  <p>No se han encontrado alumnos en la BB.DD.</p>
	  <%
	}
%>
</body>
</html>
