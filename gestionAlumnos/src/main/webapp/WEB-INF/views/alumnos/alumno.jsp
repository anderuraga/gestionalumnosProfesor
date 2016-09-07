<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alumno</title>
</head>
<body>
alumnooooo

<form:form action="save" method="POST" commandName="alumno">
	<c:if test="${alumno.codigo>0 }">
		<form:label path="codigo">
			<spring:message text="Código: "/>
		</form:label>
		<form:input path="codigo" readonly="true" size="10" disabled="true"/>
		<form:hidden path="codigo"/>
	</c:if>
	<div>
		<form:label path="nombre">
			<spring:message text="Nombre: "/>
		</form:label>
		<form:input path="nombre"/>
	</div>
	<div>
		<form:label path="apellidos">
			<spring:message text="Apellidos: "/>
		</form:label>
		<form:input path="apellidos"/>
	</div>
	<div>
		<c:if test="${alumno.codigo>0 }">
			<input type="submit" value="<spring:message text="Editar alumno"/>"/>	
		</c:if>
		<c:if test="${alumno.codigo<0 }">
			<input type="submit" value="<spring:message text="Crear alumno"/>"/>	
		</c:if>
	</div>
</form:form>

<!-- 
<form id="formulario" action="" method="post">
    <fieldset>
        <legend>Formulario</legend>
            <label value="${alumno.nombre }">Nombre: </label>
                <input id="nombre" name="nombre" type="text" />
            <label value="${alumno.apellidos }">Apellidos: </label>
                <input id="apellidos" name="apellidos" type="text" />
            <input id="campo3" name="enviar" type="submit" value="Enviar" />
    </fieldset>
</form>
 -->
</body>
</html>