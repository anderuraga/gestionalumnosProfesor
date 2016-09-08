<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../includes/header.jsp"/>

<!-- A ESTA PAGINA LLEGAMOS SI PINCHAMOS EN EDITAR ALUMNO O CREAR UNO NUEVO 
	La diferencia es que al editar mandamos el id, y al crear no
-->



<form:form action="save" commandName="alumno"> 
	<c:if test="${alumno.codigo>0}">
		<form:label path="codigo">
			<spring:message text="Codigo: "/>  
		</form:label>
		<form:input path="codigo" readonly="true" size="10" disabled="true"/> <!-- si es disabled=true no se envia -->
		<form:hidden path="codigo"/> <!-- no se ve pero se envia -->
	</c:if>
	<div>
		<form:label path="nombre">
				<spring:message text="Nombre: "/>  
		</form:label>
		<form:input path="nombre" cssErrorClass="" cssClass=""/>
		<form:errors cssClass="" path="nombre"/>
	</div>
	<div>
		<form:label path="apellidos">
				<spring:message text="Apellidos: "/>  
		</form:label>
		<form:input path="apellidos" cssErrorClass="" cssClass=""/>	
		<form:errors cssClass="" path="apellidos"/>
	</div>
	<div>
		<form:label path="fNacimiento">
				<spring:message text="Fecha de nacimiento: "/>  
		</form:label>
		<form:input path="fNacimiento" placeholder="dd/MM/yyyy" cssErrorClass="" cssClass=""/>	
		<form:errors cssClass="" path="fNacimiento"/>
	</div>
	<div>
		<form:label path="email">
				<spring:message text="Email: "/>  
		</form:label>
		<form:input path="email" placeholder="nombredominio.com" cssErrorClass="" cssClass=""/>	
		<form:errors cssClass="" path="email"/>
	</div>
	<div>
		<c:if test="${alumno.codigo>0}">
			<input type="submit" value="<spring:message text="Editar Alumno"/>"/>
		</c:if>
		<c:if test="${alumno.codigo<0}">
			<input type="submit" value="<spring:message text="Crear Alumno"/>"/>
		</c:if>
	</div>
</form:form>


