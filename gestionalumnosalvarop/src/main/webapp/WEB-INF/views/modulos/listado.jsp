<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de modulos</title>
<h1>Listado de modulos</h1>

	<c:forEach items="${modulos}" var="modulo">
	
		<p>${modulo.nombre} ${modulo.codigo}</p><a href="modulo"></a>
	
	
	</c:forEach>
</head>
<body>

</body>
</html>