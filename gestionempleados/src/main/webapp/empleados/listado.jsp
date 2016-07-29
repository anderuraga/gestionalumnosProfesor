<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../includes/header.jsp"/>

<main>

<div class="row">
	<a class="btn btn-info" href="index.jsp"><span class="glyphicon glyphicon-arrow-left">Volver</span></a>
	<a class="btn btn-success" href="${constantes.empleadoServlet}?${constantes.parCodigo}=${constantes.parCodigo}">
	<span class="glyphicon glyphicon-plus">Nuevo Empleado</span>
	</a>


	<table class="table">
	<tr>
		<th>NOMBRE</th>
		<th>APELLIDOS</th>
		<th>DNI</th>
		<th>DIRECCION</th>
		<th>LOCALIDAD</th>
		<th>CP</th>
		<th>FECHA NACIMIENTO</th>
		<th>FECHA CONTRATACIÓN</th>
	</tr>
		<c:forEach items="${listadoEmpleados}" var="empleado">
	<tr>
		<td>${empleado.nombre}</td>
	</tr>		
		</c:forEach>
	
	</table>








</div>

</main>
<%@ include file="../includes/footer.jsp" %>