<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado alumnos</title>
</head>
<body>
<a href="alumnos/addAlumno">Crear alumno nuevo</a>
<c:forEach items="${listado_alumnos}" var="alumno">
	<p>
		<a href="alumnos/${alumno.codigo }">
			${alumno.nombre} 
			${alumno.apellidos}
		</a> 
	</p>

</c:forEach>
<%
/*
List<Alumno>alumnos=(List<Alumno>)request.getAttribute("listado_alumnos");
if(alumnos.size()>0){
	for(Alumno alumno:alumnos){
		out.print("<p>"+alumno.getNombre()+" "+alumno.getApellidos()+"</p>");
	}
	%>
	<%
}else{
	%>
	<p>No se han encontrado alumnos en la base de datos</p>
	<% 
}*/
%>

<a href="index">Atrás</a>
</body>
</html>