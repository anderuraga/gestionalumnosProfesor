<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../includes/header.jsp" />

<div class="row">
	<div class="col-xs-6">
		<div class="row">
			<div class="col-xs-12">
				<table class="table">
					<thead>
						<th>DNI</th>
						<th>Nombre y apellidos</th>
					</thead>
					<tbody>
					<c:choose>
						<c:when test="${!empty listado_alumnos}">
							<c:forEach items="${listado_alumnos}" var="alumno">
								<tr>
									<td>${alumno.dni}</td>
									<td><span class="registros">${alumno.apellidos}</span>,<span class="registros">
											${alumno.nombre}</span></td>
									<td><a href="${properties.servletAlumno}?${properties.parCodigo}=${alumno.codigo}"
										class="btn btn-warning"><i class="fa fa-pencil"></i></a></td>
									<td><form action='${properties.servletAlumno}' method='POST'>
											<input type='hidden' id='${properties.parCodigo}' name='${properties.parCodigo}'
												value='${alumno.codigo}' /> <input type='hidden' id='${properties.parOperacion}'
												name='${properties.parOperacion}' value='${properties.opDelete}' />
											<button type='submit' class='btn btn-danger'>
												<span class='fa fa-times'></span>
											</button>
										</form></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
						<tr><td colspan="4">No hay alumnos en la base de datos.</td><tr>
						</c:otherwise>
						</c:choose>
						<tr>
							<td colspan="4"><a class="btn btn-success"
								href="${properties.servletAlumno}?${properties.parCodigo}=<%=Alumno.CODIGO_ALUMNO%>">
									Añadir <span class="fa fa-plus"></span>
							</a></td>
						</tr>
					</tbody>
				</table>

			</div>

		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp"%>