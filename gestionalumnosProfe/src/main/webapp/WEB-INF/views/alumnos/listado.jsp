<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Listado alumnoss</h1>
<c:forEach items="${listado_alumnos}" var="alumno">
	
	${alumno.codigo }
	${alumno.nombre }
	${alumno.apellidos }
	<a href="alumnos/${alumno.codigo }">Editar</a>
	<form action="alumnos/${alumno.codigo}" method="POST">
	
	<input type="submit" value="Borrar"/>
	
	</form>
</c:forEach>
</body>
</html>