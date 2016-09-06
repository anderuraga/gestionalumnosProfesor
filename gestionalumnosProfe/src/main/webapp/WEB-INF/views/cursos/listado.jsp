<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Listado cursos</h1>
<c:forEach items="${listado_cursos}" var="curso">
	
	${curso.codigo }
	${curso.nombre }
	
	<a href="cursos/${curso.codigo }">Editar</a>
	<form action=cursos/${curso.codigo}" method="POST">
	
	<input type="submit" value="Borrar"/>
	
	</form>
</c:forEach>
</body>
</html>