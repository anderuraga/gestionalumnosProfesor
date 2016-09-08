<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Listado alumnoss</h1>
<a href="alumnos/addAlumno">Crear Alumno</a>
<c:forEach items="${listado_alumnos}" var="alumno">
	<div><p>
	${alumno.codigo } 
	${alumno.nombre }
	${alumno.apellidos }
	 <fmt:formatDate pattern="dd-MM-yyyy" 
            value="${alumno.fNacimiento }" />
	<a href="alumnos/${alumno.codigo }">Editar</a>
	<form action="alumnos/${alumno.codigo}" method="POST">
	
	<input type="submit" value="Borrar"/>
	
	</form>
	</p>
	</div>
</c:forEach>
</body>
</html>