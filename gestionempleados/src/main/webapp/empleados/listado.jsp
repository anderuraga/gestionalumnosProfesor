<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<main>
<div class="row">
	<div class="col-xs-12 col-md-8 col-md-offset-2">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>DNI</th>
					<th>Nombre</th>
					<th>Apellidos</th>
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope[constantes.listadoEmpleados]}" var="empleado">
					<tr>
						<td><strong>${empleado.dni }</strong></td>
						<td>${empleado.nombre}</td>
						<td>${empleado.apellidos}</td>
						<td><a href="${constantes.empleadoServlet}?${constantes.id}=${empleado.codigo}"
							class="btn btn-warning"><i class="fa fa-pencil"></i></a></td>
						<td><a href="#" class="btn btn-danger"><i class="fa fa-times"></i></a></td>
					</tr>
				</c:forEach>
				<tr><td><a href="${constantes.empleadoServlet}?${constantes.id}=<%=Empleado.CODIGO_EMPLEADO %>"
							class="btn btn-success"><i class="fa fa-plus"></i></a></td></tr>
			</tbody>
		</table>
	</div>
</div>
</main>
<%@ include file="../includes/footer.jsp"%>