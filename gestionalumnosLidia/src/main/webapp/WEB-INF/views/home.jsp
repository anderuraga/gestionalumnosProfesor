<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>P�gina de inicio</title>
</head>
<body>
<h1>
	Bienvenido a la aplicaci�n de gesti�n de alumnos de Ipartek. 
</h1>

<%
	List<Alumno>alumnos=(List)request.getAttribute("listado-alumnos");
		if(alumnos.size()>0){
			
			for(Alumno alumno: alumnos){
			out.print("<p>"+alumno.getNombre()+" " +alumno.getApellidos() +"</p>");
			}
			
		}else{
			%>
			No se han encontrado alumnos en la base de datos.
			<%
		}


%>




<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
