<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../includes/header.jsp"/>

<main>

<%
 	Alumno alumno = (Alumno) request.getAttribute("alumno");

%>

	<form id="formAlumno" method="post" action="<c:url value='/alumnos' />">
	
		<input type="hidden" id="codigo" name="codigo" value="<%=alumno.getCodigo()%>" />
		<div class="form-group">
			<label for="nombre-alumno">NOMBRE:</label> 
			<input type="text" class="form-control" id="nombre-alumno"
				  name="nombre-alumno" value="<%=alumno.getNombre()%>" />
		</div>
		<div class="form-group">
			<label for="apellidos-alumno">APELLIDOS:</label> 
			<input type="text" class="form-control" id="apellidos-alumno"
				  name="apellidos-alumno" value="<%=alumno.getApellidos()%>" />
		</div>
		<button id="btnGuardarAlum" type="submit" class="btn btn-success pull-right">Guardar</button>
	</form>
</main>