<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<jsp:include page="../includes/header.jsp" />

<!-- A ESTA PAGINA LLEGAMOS SI PINCHAMOS EN EDITAR ALUMNO O CREAR UNO NUEVO 
	La diferencia es que al editar mandamos el id, y al crear no
-->
<div class="row">
	<div class="col-xs-6 col-sm-3">
		<form:form action="save" commandName="alumno">
			<c:if test="${alumno.codigo>0}">
				<form:label path="codigo">
					<spring:message text="Codigo: " />
				</form:label>
				<form:input path="codigo" readonly="true" size="10" disabled="true" />
				<!-- si es disabled=true no se envia -->
				<form:hidden path="codigo" />
				<!-- no se ve pero se envia -->
			</c:if>
			<div class="form-group">
				<form:label path="nombre">
					<spring:message code="alumno.nombre" />
				</form:label>
				<form:input path="nombre" cssErrorClass="" cssClass="form-control" />
				<form:errors cssClass="text-danger" path="nombre" />
			</div>
			<div class="form-group">
				<form:label path="apellidos">
					<spring:message code="alumno.apellidos" />
				</form:label>
				<form:input path="apellidos" cssErrorClass=""
					cssClass="form-control" />
				<form:errors cssClass="text-danger" path="apellidos" />
			</div>
			<div class="form-group">
				<form:label path="fNacimiento">
					<spring:message code="alumno.fNacimiento" />
				</form:label>
				<form:input path="fNacimiento" placeholder="dd/MM/yyyy"
					cssErrorClass="" cssClass="form-control" />
				<form:errors cssClass="text-danger" path="fNacimiento" />
			</div>
			<div class="form-group">
				<form:label path="email">
					<spring:message code="alumno.email" />
				</form:label>
				<form:input path="email" placeholder="nombredominio.com"
					cssErrorClass="" cssClass="form-control" />
				<form:errors cssClass="text-danger" path="email" />
			</div>
			<div>
				<c:if test="${alumno.codigo>0}">
					<input type="submit" class="btn btn-info" value="<spring:message text="Editar Alumno"/>" />
				</c:if>
				<c:if test="${alumno.codigo<0}">
					<input type="submit" class="btn btn-info" value="<spring:message text="Crear Alumno"/>" />
				</c:if>
			</div>
		</form:form>
	</div>
</div>