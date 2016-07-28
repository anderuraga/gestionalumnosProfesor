<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<main>
<div class="row">
	<div class="col-xs-12">
		<form method="post" action="${constantes.empleadoServlet }"
			name="empForm">
			<div class="col-xs-12 col-md-4">
				<fieldset>
					<legend>Datos Personales</legend>
					<div class="form-group">
							<script type="text/javascript">
							$(function () {
								  $('[data-toggle="tooltip"]').tooltip()
								})</script>				 
						<label class="control-label" for="${constantes.parDni}">Dni: <span class="badge" data-toggle="tooltip" data-placement="right" title="XXXXXXXX Y">i</span></label>
						<input required type="text" class="form-control" placeholder="DNI"
							name="${constantes.parDni }" id="${constantes.parDni }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parNombre}">Nombre:</label>
						<input required type="text" class="form-control"
							placeholder="Nombre" name="${constantes.parNombre }"
							id="${constantes.parNombre }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parApellidos}">Apellidos:</label>
						<input required type="text" class="form-control"
							placeholder="Apellidos" name="${constantes.parApellidos }"
							id="${constantes.parApellidos }" />
					</div>

					<div class="form-group">
						<label class="control-label" for="${constantes.parFNacimiento }">Fecha
							de Nacimiento:</label> <input required type="date" class="form-control"
							name="${constantes.parFNacimiento }"
							id="${constantes.parFNacimiento }" />
					</div>
				</fieldset>
			</div>
			<div class="col-xs-12 col-md-4">
				<fieldset>
					<legend>Datos Empleado</legend>
					<div class="form-group">

						<label class="control-label" for="${constantes.parDni}">Nº
							Seguridad Social:</label> <input required type="text"
							class="form-control" placeholder="Nº Seguridad Social"
							name="${constantes.parSS }" id="${constantes.parSS }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parCC}">Nº
							C/C:</label> <input required type="text" class="form-control"
							placeholder="Nº Cuenta Corriente" name="${constantes.parCC }"
							id="${constantes.parCC }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parFContratacion }">Fecha
							de Contratación:</label> <input required type="date" class="form-control"
							name="${constantes.parFContratacion }"
							id="${constantes.parFContratacion }" value="1000-02-03" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parCodDep}">Departamento</label>
						<input required type="text" class="form-control"
							placeholder="Departamento" name="${constantes.parCodDep }"
							id="${constantes.parCodDep }" />
					</div>
				</fieldset>
			</div>
			<div class="col-xs-12 col-md-4">
				<fieldset>
					<legend>Datos Adicionales</legend>
					<div class="form-group">
						<label class="control-label" for="${constantes.parDireccion}">Dirección:</label>
						<input required type="text" class="form-control"
							placeholder="Dirección" name="${constantes.parDireccion }"
							id="${constantes.parDireccion }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parLocalidad}">Localidad:</label>
						<input required type="text" class="form-control"
							placeholder="Localidad:" name="${constantes.parLocalidad }"
							id="${constantes.parLocalidad }" />
					</div>
					<div class="form-group">
						<label class="control-label" for="${constantes.parCP}">Código
							Postal:</label> <input required type="text" class="form-control"
							placeholder="Código Postal" name="${constantes.parCP }"
							id="${constantes.parCP }" />
					</div>

				</fieldset>
			</div>
			<button type="submit" class="btn btn-success">ENVIAR</button>
		</form>
	</div>
</div>
</main>
<%@ include file="../includes/footer.jsp"%>