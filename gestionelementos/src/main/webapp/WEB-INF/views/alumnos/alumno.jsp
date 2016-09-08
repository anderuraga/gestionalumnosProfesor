<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>

<%@page import="java.util.List"%>

<jsp:include page="../includes/header.jsp" />
<form:form action="alumnos/saveAlumno" commandName="alumno">
	<c:if test="${!empty alumno }">
		<form:label path="codigo">
			<spring:message text="Codigo:" />
		</form:label>
		<form:input path="codigo" readonly="true" size="10" disabled="true" />
		<form:hidden path="codigo" />
	</c:if>
	<div>
		<form:label path="nombre">
			<spring:message text="Nombre:" />
		</form:label>
		<form:input path="nombre" cssErrorClass="" readonly="false" size="10"
			disabled="false" />
		<form:errors cssClass="" path="nombre" />
	</div>
	<div>
		<form:label path="apellidos">
			<spring:message text="Apellidos:" />
		</form:label>
		<form:input path="apellidos" cssErrorClass="" readonly="false"
			size="10" disabled="false" />
		<form:errors cssClass="" path="apellidos" />

	</div>
	<div>
		<form:label path="fechaNacimiento" cssClass="sr-only">
<spring:message text="fecha de Nacimiento"/>
		</form:label>
		<form:input path="fechaNacimiento" placeholder="dd/MM/yyyy"/>
		<form:errors cssClass="" path="fechaNacimiento"/>
	</div>
	<div>
		<c:if test="${alumno.codigo>0}">
			<input type="submit" value="<spring:message text="Editar Alumno"/>" />
		</c:if>
		<c:if test="${alumno.codigo<0}">
			<input type="submit" value="<spring:message text="Crear Alumno"/>" />
		</c:if>
	</div>
</form:form>
</body>
</html>