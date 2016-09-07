<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado modulos</title>
</head>
<body>
Listado modulos
<a href="modulos/addModulo">Crear módulo nuevo</a>
<c:forEach items="${listado_modulos }" var="modulos">
	<p>
		<a href="modulos/${modulo.codigo }">
			${modulos.nombre }
		</a>
	</p>

</c:forEach>

<a href="index">Atrás</a>
</body>
</html>