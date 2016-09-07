<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de alumnos</title>
</head>
<body>
<h1>Listado de alumnos</h1>

	<c:forEach items="${alumnos}" var="alumno">
	
		<p>${alumno.nombre} ${alumno.apellidos} ${alumno.codigo}</p><a href="alumno"></a>
	
	
	</c:forEach>




</body>
</html>