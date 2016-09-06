<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>

<body>
<form action="" method="POST">
${alumno.nombre }---${alumno.apellidos}
<input type="hidden" name="id" value="${alumno.codigo }"/>
<input type="text" name="nombre" value="${alumno.nombre }"/>
<input type="text" name="apellidos" value="${alumno.apellidos }"/>
<input type="submit" value="Guardar">
</form>
</body>
</html>