<%@page import="com.ipartek.formacion.dao.persistencia.Curso"%>
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



<form:form action="cursos/save" commandName="curso"> 
	<c:if test="${curso.codigo>0}">
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
		<form:input path="nombre"  cssErrorClass="" cssClass="" />	
		<form:errors cssClass="" path="nombre"/>
	</div>
	<div>
		<c:if test="${curso.codigo>0}">
			<input type="submit" value="<spring:message text="Editar Curso"/>"/>
		</c:if>
		<c:if test="${curso.codigo<0}">
			<input type="submit" value="<spring:message text="Crear Curso"/>"/>
		</c:if>
	</div>
</form:form>


