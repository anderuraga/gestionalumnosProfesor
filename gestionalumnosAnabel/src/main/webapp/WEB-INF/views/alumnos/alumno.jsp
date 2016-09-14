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
		<form:form class="form-horizontal" action="saveAlumno"
			commandName="alumno">
			<c:if test="${alumno.codigo > 0}">
				<div class="form-group">
					<div class="col-xs-12">
						<form:label path="codigo">
							<!-- Si lo hiciesemos mediante lenguajes pondriamos code = "alumno.codigo" -->

							<spring:message text="codigo" />
						</form:label>
						<form:input path="codigo" readonly="true" size="10" disabled=""/>
						<form:hidden path="codigo" />
					</div>
				</div>
			</c:if>
			<div class="form-group">
				<div class="col-xs-12">
					<form:label path="nombre">
						<spring:message text="Nombre" />
					</form:label>
					<form:input path="nombre" placeholder="Nombre" cssClass="" cssErrorClass="" />
					<form:errors path="nombre" cssClass="" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-12">
					<form:label path="apellidos">
						<spring:message text="Apellidos" />
					</form:label>
					<form:input path="apellidos" placeholder="Apellidos" cssClass="" cssErrorClass=""/>
					<form:errors path="apellidos" cssClass=""/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-12">
					<form:label path="fNacimiento">
						<spring:message text="Fecha de Nacimiento" />
					</form:label>
					<form:input path="fNacimiento" placeholder="dd/MM/yyyy" />
					<form:errors path="fNacimiento" cssClass="" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-12">
					<form:label path="email">
						<spring:message text="Email" />
					</form:label>
					<form:input path="email" cssClass="" cssErrorClass="" placeholder="Email"/>
					<form:errors path="email" cssClass="" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-12">
					<form:label path="telefono">
						<spring:message text="Teléfono" />
					</form:label>
					<form:input path="telefono" cssClass="" cssErrorClass="" placeholder="Teléfono"/>
					<form:errors path="telefono" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-12">
					<c:if test="${alumno.codigo > 0}">
						<input class="btn btn-default" type="submit"
							value="<spring:message text="Editar alumno"/>" />
					</c:if>
					<c:if test="${alumno.codigo < 0}">
						<input class="btn btn-default" type="submit" value="<spring:message text="Crear alumno"/>" />
					</c:if>
				</div>
			</div>
		</form:form>
	</div>
</div>
<jsp:include page="../includes/footer.jsp" />