<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../includes/header.jsp" />
<c:set var="lista" value="${listado_empleados}" />
<main>
<div class="row">
	<div class="col-xs-6">
		<div class="row">
			<div class="col-xs-12">
				<c:if test="${!empty lista}">
					<table class="table">
						<thead>
							<th>DNI</th>
							<th>Nombre y apellidos</th>
						</thead>
						<tbody>
							<c:forEach items="${lista}" var="empleado">
								<tr>

									<td>${empleado.dni}</td>
									<td>${empleado.apellidos},${empleado.nombre}</td>
									<td></td>
									<td><form action='${properties.servletEmpleado}' method='POST'>
											<input type='hidden' id='${properties.parCodigo}' name='${properties.parCodigo}'
												value='${empleado.codigo}' /> <input type='hidden' id='${properties.parOperacion}'
												name='${properties.parOperacion}' value='${properties.opDelete}' />
											<button type='submit' class='btn btn-danger'>
												<span class='fa fa-times'></span>
											</button>
										</form></td>

<!-- 									<a class="col-xs-7" -->
<%-- 										href="${properties.servletEmpleado}?${properties.parCodigo}=${empleado.codigo}">${empleado.nombre} --%>
<%-- 										${empleado.apellidos}</a> --%>


								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
				<div class="col-xs-12">
					<a class="btn btn-success"
						href="${properties.servletEmpleado}?${properties.parCodigo}=<%=Empleado.CODIGO_EMPLEADO%>">
						Añadir <span class="fa fa-plus"></span>
					</a>
				</div>

			</div>

		</div>
	</div>
</div>
</main>
<%@include file="../includes/footer.jsp"%>