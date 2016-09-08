<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Alumno</title>
	</head>
	
	<body>
		
		<form:form action="alumnos/save" modelAttribute="alumno" commandName="alumno">
			<c:if test="${!empty alumno}">
				<form:label path="codigo">
					<spring:message text="Codigo: " />
				</form:label>
				<form:input path="codigo" readonlye="true" size="10" disabled="true" />
				<form:hidden path="codigo" />
			</c:if>
			
			<form:label path="nombre">
				<spring:message text="Nombre: "/>
			</form:label>
			<form:input path="nombre" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="nombre" />
			
			<form:label path="apellidos">
				<spring:message text="Apellidos: " />
			</form:label>
			<form:input path="apellidos" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="apellidos" />
			
			<form:label path="fNacimiento">
				<spring:message text="Fecha Nacimento: " />
			</form:label>
			<form:input path="fNacimiento" placeholder="dd/MM/yyyy" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="fNacimiento" />
			
			<c:if test="${alumno.codigo>0}">
				<input type="submit" value="<spring:message text="Editar Alumno"/>"/>
			</c:if>
			
			<c:if test="${ alumno.codigo<0}">
				<input type="submit" value="<spring:message text="Crear Alumno"/>"/>
			</c:if>
		</form:form>
		
	</body>
</html>