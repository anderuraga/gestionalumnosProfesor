<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">
	<div class="col-xs-12">
		<form:form action="saveAlumno" commandName="alumno">
			<c:if test="${alumno.codigo > 0}">
				<div>
					<form:label path="codigo">
						<spring:message code="alumno.codigo" />
					</form:label>
					<form:input path="codigo" readonly="true" size="10" disabled="" />
					<form:hidden path="codigo" />
				</div>
			</c:if>
			<div>
				<form:label path="nombre">
					<spring:message text="Nombre" />
				</form:label>
				<form:input path="nombre" cssClass="" cssErrorClass="" />
				<form:errors path="nombre" cssClass="" />
			</div>
			<div>
				<form:label path="apellidos">
					<spring:message text="Apellidos" />
				</form:label>
				<form:input path="apellidos" />
			</div>
			<div>
				<form:label path="fNacimiento">
					<spring:message text="Fecha de Nacimiento" />
				</form:label>
				<form:input path="fNacimiento" placeholder="dd/MM/yyyy" />
				<form:errors path="fNacimiento" cssClass="" />
			</div>
			<div>
				<c:if test="${alumno.codigo > 0}">
					<input type="submit" value="<spring:message text="Editar alumno"/>" />
				</c:if>
				<c:if test="${alumno.codigo < 0}">
					<input type="submit" value="<spring:message text="Crear alumno"/>" />
				</c:if>
			</div>

		</form:form>
	</div>
</div>
<jsp:include page="../includes/footer.jsp" />