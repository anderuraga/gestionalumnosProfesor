<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alumno</title>
</head>
<body>

<form:form action="alumnos/save" commandName="alumno">

	<c:if test="${!empty alumno }">
	
		<form:label path="codigo">
			<spring:message text="Codigo"/>
		</form:label>
		<form:input path="codigo" readonly="true" size="10" disabled="true"/>
		<form:hidden path="codigo"/>
	</c:if>
	<div>
		<form:label path="nombre">
			<spring:message text="nombre"/>
		</form:label>
		<form:input path="nombre" cssErrorClass="" cssClass=""/>
		<form:errors cssClass="" path="nombre"/>
	</div>
	<div>
		<form:label path="apellidos">
			<spring:message text="Apellidos"/>
		</form:label>
		<form:input path="apellidos" cssErrorClass="" cssClass=""/>
		<form:errors cssClass="" path="apellidos"/>
	</div>	
	<div>
		<form:label path="fNacimiento" cssClass="sr-only">
			<spring:message text="Fecha de nacimiento:"/>
		</form:label>
		<form:input path="fNacimiento" placeholder="dd/MM/yyyy"/>
		<form:errors cssClass=""/>
	</div>
	<div>
		<c:if test="${!empty alumno.codigo}">
			<input type="submit" value="<spring:message text="Editar Alumno"/>">
		</c:if>
		
		<c:if test="${empty alumno.codigo}">
			<input type="submit" value="<spring:message text="Crear Alumno"/>">
		</c:if>
	</div>
	
</form:form>

</body>
</html>