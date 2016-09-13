<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Candidato"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Curso"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Modulo"%>
<%@page import="java.util.List"%>

<jsp:include page="../includes/header.jsp" />

	<form:form action="saveCandidato" commandName="candidato">
		<c:if test="${!empty candidato }">
			<form:label path="codigo">
				<spring:message text="Codigo:" />
			</form:label>
			<form:input path="codigo" readonly="true" size="10" disabled="true" />
			<form:errors cssClass="" path="codigo" />
			<form:hidden path="codigo" />
		</c:if>
		<div>
			<form:label path="nombre">
				<spring:message text="Nombre:"/>
			</form:label>
			<form:input path="nombre" readonly="false" size="40" disabled="false" />
			<form:errors cssClass="" path="nombre" />
		</div>
			<div>
			<form:label path="apellidos">
				<spring:message text="Apellidos:"/>
			</form:label>
			<form:input path="apellidos" readonly="false" size="40" disabled="false" />
			<form:errors cssClass="" path="apellidos" />
		</div>
		<div>
		<c:if test="${candidato.codigo>0}">
			<input type="submit" value="<spring:message text="Editar Candidato"/>"/>	
		</c:if>		
		<c:if test="${candidato.codigo<0}">
			<input type="submit" value="<spring:message text="Crear Candidato"/>"/>	
		</c:if>	
		</div>
	</form:form>
</body>
</html>