<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<main>
<div class="row">
	<div class="col-xs-12">
		<form method="post" action="${constantes.empleadoServlet }" name="empForm">
			<div class="col-xs-12 col-md-4">
				<c:set var="emp" value="<%=new Empleado()%>" />
				<c:set var="operacion" value="${constantes.opCreate}" />
				<c:if test="${not empty requestScope[constantes.attEmp]}">
					<c:set var="emp" value="${requestScope[constantes.attEmp]}" />
					<c:set var="operacion" value="${constantes.opUpdate}" />
				</c:if>
				<fieldset>
					<legend>Datos Personales</legend>
					<div class="form-group">
						<script type="text/javascript">
							$(function() {
								$('[data-toggle="tooltip"]').tooltip()
							})
						</script>
						<label class="control-label" for="${constantes.parDni}">Dni: <span class="badge"
							data-toggle="tooltip" data-placement="right" title="Formato: 8 digitos + letra">i</span></label> <input
							required type="text" class="form-control" placeholder="DNI" name="${constantes.parDni }"
							id="${constantes.parDni }" value="${emp.dni }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parNombre}">Nombre:</label> <input required
							type="text" class="form-control" placeholder="Nombre" name="${constantes.parNombre }"
							id="${constantes.parNombre }" value="${emp.nombre }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parApellidos}">Apellidos:</label> <input
							required type="text" class="form-control" placeholder="Apellidos"
							name="${constantes.parApellidos }" id="${constantes.parApellidos }" value="${emp.apellidos }" />
					</div>
					<fmt:formatDate value="${emp.fNacimiento}" pattern="yyyy-MM-dd" var="fNac" type="date" />
					<div class="form-group">
						<label class="control-label" for="${constantes.parFNacimiento }">Fecha de Nacimiento:</label>
						<input required type="date" class="form-control" name="${constantes.parFNacimiento }"
							id="${constantes.parFNacimiento }" value="${fNac }" />
					</div>
				</fieldset>
			</div>
			<div class="col-xs-12 col-md-4">
				<fieldset>
					<legend>Datos Empleado</legend>
					<div class="form-group">

						<label class="control-label" for="${constantes.parDni}">Nº Seguridad Social:</label> <input
							required type="text" class="form-control" placeholder="Nº Seguridad Social"
							name="${constantes.parSS }" id="${constantes.parSS }" value="${emp.nSeguridadSocial }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parCC}">Nº C/C:</label> <input required
							type="text" class="form-control" placeholder="Nº Cuenta Corriente"
							name="${constantes.parCC }" id="${constantes.parCC }" value="${emp.nCuentaBancaria }" />
					</div>
					<fmt:formatDate value="${emp.fContratacion}" pattern="yyyy-MM-dd" var="fCon" type="date" />
					<div class="form-group">
						<label class="control-label" for="${constantes.parFContratacion }">Fecha de
							Contratación:</label> <input required type="date" class="form-control"
							name="${constantes.parFContratacion }" id="${constantes.parFContratacion }" value="${fCon }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parCodDep}">Departamento</label> <select
							required class="form-control" name="${constantes.parCodDep }" id="${constantes.parCodDep }">
							<c:forEach items="${requestScope[constantes.listadoDep] }" var="dep">
								<option ${emp.departamento.codigo == dep.codigo ? "selected" : "" } value="${dep.codigo }">${dep.nombre }</option>
							</c:forEach>
						</select>
					</div>
				</fieldset>
			</div>
			<div class="col-xs-12 col-md-4">
				<fieldset>
					<legend>Datos Adicionales</legend>
					<div class="form-group">
						<label class="control-label" for="${constantes.parDireccion}">Dirección:</label> <input
							required type="text" class="form-control" placeholder="Dirección"
							name="${constantes.parDireccion }" id="${constantes.parDireccion }" value="${emp.direccion }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parLocalidad}">Localidad:</label> <input
							required type="text" class="form-control" placeholder="Localidad:"
							name="${constantes.parLocalidad }" id="${constantes.parLocalidad }" value="${emp.localidad }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parCP}">Código Postal:</label> <input required
							type="text" class="form-control" placeholder="Código Postal" name="${constantes.parCP }"
							id="${constantes.parCP }" value="${emp.codigoPostal }" />
					</div>

				</fieldset>

			</div>
			<div class="col-xs-12">
				<button type="submit" class="btn btn-success btn-lg">${operacion == constantes.opCreate ? "Añadir Empleado": "Actualizar Datos" }</button>
			</div>
		</form>
	</div>
</div>
</main>
<%@ include file="../includes/footer.jsp"%>