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
		
		<form:form action="save" modelAttribute="alumno" commandName="alumno">
			<c:if test="${!empty alumno}">
				<form:label path="codigo">
					<spring:message text="Codigo: " />
				</form:label>
				<form:input path="codigo" readonlye="true" size="10" disabled="true" />
				<form:hidden path="codigo" />
			</c:if>
			
			<br/>
			
			<form:label path="nombre">
				<spring:message text="Nombre: "/>
			</form:label>
			<form:input path="nombre" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="nombre" />
			
			<br/>
			
			<form:label path="apellidos">
				<spring:message text="Apellidos: " />
			</form:label>
			<form:input path="apellidos" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="apellidos" />
			
			<br/>
			
			<form:label path="dni_nie">
				<spring:message text="DNI: " />
			</form:label>
			<form:input path="dni_nie" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="dni_nie" />
			
			<br/>
			
			<form:label path="fNacimiento">
				<spring:message text="Fecha Nacimento: " />
			</form:label>
			<form:input path="fNacimiento" placeholder="dd/MM/yyyy" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="fNacimiento" />
			
			<br/>
			
			<form:label path="email">
				<spring:message text="Email: " />
			</form:label>
			<form:input path="email" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="email" />
			
			<br/>
			
			<form:label path="telefono">
				<spring:message text="Telefono: " />
			</form:label>
			<form:input path="telefono" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="telefono" />
			
			<br/>
			
			<form:label path="codGenero">
				<spring:message text="Codigo Genero: " />
			</form:label>
			<form:input path="codGenero" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="codGenero" />
			
			<br/>
			
			<c:if test="${alumno.codigo>0}">
				<input type="submit" value="<spring:message text="Editar Alumno"/>"/>
			</c:if>
			
			<c:if test="${ alumno.codigo<0}">
				<input type="submit" value="<spring:message text="Crear Alumno"/>"/>
			</c:if>
		</form:form>
		
	</body>
</html>