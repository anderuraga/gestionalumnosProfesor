<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../includes/header.jsp" />

<form:form action="saveAlumno" commandName="alumno">
	<c:if test="${alumno.codigo > 0}">
		<div>
			<form:label path="codAlumno">
				<spring:message text="Codigo" />
			</form:label>
			<form:input path="codAlumno" readonly="true" size="10" disabled="" />
			<form:hidden path="codAlumno" />
		</div>
		<div>
			<form:label path="nombre">
				<spring:message text="Nombre" />
			</form:label>
			<form:input path="nombre" readonly="true" size="10" disabled="" />
			<form:hidden path="nombre" />
		</div>
		<div>
			<form:label path="apellidos">
				<spring:message text="Apellidos" />
			</form:label>
			<form:input path="apellidos" readonly="true" size="10" disabled="" />
			<form:hidden path="apellidos" />
		</div>
		<div>
			<c:if test="${alumno.codigo > 0}">
				<input type="submit" value="<spring:message text="Editar alumno"/>"/>
			</c:if>
			<c:if test="${alumno.codigo < 0}">
				<input type="submit" value="<spring:message text="Crear alumno"/>"/>
			</c:if>
		</div>
	</c:if>
</form:form>

<jsp:include page="../includes/footer.jsp" />