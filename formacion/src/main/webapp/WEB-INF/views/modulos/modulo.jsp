<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Modulo</title>
	</head>
	
	<body>
		
		<form:form action="save" modelAttribute="modulo" commandName="modulo">
			<c:if test="${!empty modulo}">
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
			
			<form:label path="uFormativa">
				<spring:message text="Unidad Formativa: " />
			</form:label>
			<form:input path="uFormativa" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="uFormativa" />
			
			<br/>
			
			<form:label path="duracion">
				<spring:message text="Duracion: " />
			</form:label>
			<form:input path="duracion" cssClass="" cssErrorClass="" />
			<form:errors cssClass="" path="duracion" />
			
			<br/>
			
			<form:select path="">
				<form:option path="" value=""></form:option>
			</form:select>
			
			<br/>
			
			<c:if test="${modulo.codigo>0}">
				<input type="submit" value="<spring:message text="Editar Modulo"/>"/>
			</c:if>
			
			<c:if test="${ modulo.codigo<0}">
				<input type="submit" value="<spring:message text="Crear Modulo"/>"/>
			</c:if>
		</form:form>
		
	</body>
</html>