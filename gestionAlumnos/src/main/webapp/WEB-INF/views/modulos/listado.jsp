<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado modulos</title>
</head>
<body>
Listado modulos
<a href="modulos/addModulo">Crear módulo nuevo</a>
<c:forEach items="${listado_modulos }" var="modulo">
	<p>
		<a href="modulos/${modulo.codigo }">
			${modulo.nombre }
		</a>
	</p>

</c:forEach>

<a href="index">Atrás</a>
</body>
</html>