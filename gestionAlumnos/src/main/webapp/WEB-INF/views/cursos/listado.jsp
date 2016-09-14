<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado cursos</title>
</head>
<body>
listado cursos 

<a href="cursos/addCurso">Crear curso nuevo</a>
<c:forEach items="${listado_cursos}" var="curso">
	<p>
		<a href="cursos/${curso.codigo }">
			${curso.nombre} 
		</a> 
	</p>

</c:forEach>

<a href="index">Atr�s</a>
</body>
</html>