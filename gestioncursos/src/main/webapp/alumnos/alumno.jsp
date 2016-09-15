<%@page import="java.util.Properties"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.pojo.Idioma"%>
<%@page import="com.ipartek.formacion.service.Genero"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.ipartek.formacion.controller.exception.AlumnoError"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<c:choose>
	<c:when test="${!empty alumno}">
		<c:set var="operacion" value="${properties.opUpdate}" />
	</c:when>
	<c:otherwise>
		<c:set var="alumno" value="<%=new Alumno()%>" />
		<c:set var="operacion" value="${properties.opCreate }" />
	</c:otherwise>
</c:choose>
<main>
<div class="row">

	<div class="col-xs-12">
		<form name="formulario" id="formulario" method="POST" action="${properties.servletAlumno }">
			<div class="col-xs-6">
				<input type="hidden" id="${properties.parCodigo}" name="${properties.parCodigo}"
					value="${alumno.codigo }" /> <input type="hidden" id="${properties.parOperacion}"
					name="${properties.parOperacion}" value="${operacion }" />
				<fieldset>
					<legend>Datos Personales</legend>
					<div class="form-group">
						<label for="${properties.parNombre}">NOMBRE: </label> <input type="text" class="form-control"
							name="${properties.parNombre}" id="${properties.parNombre}" value="${alumno.nombre }" />

					</div>
					<div class="form-group">
						<label for="${properties.parApellidos }">APELLIDOS: </label> <input type="text"
							class="form-control" name="${properties.parApellidos}" id="${properties.parApellidos }"
							value="${alumno.apellidos }" />
					</div>
					<div class="form-group">
						<label for="${properties.parDni} ">DNI: </label> <input type="text" required
							class="form-control"
							pattern="(([X-Z]{1})([-]?)(\d{7})([-]?)([A-Z]{1}))|((\d{8})([-]?)([A-Za-z]{1}))"
							name="${properties.parDni }" id="${properties.parDni }" value="${alumno.dni }" />
					</div>
					<c:set var="fecha" value="${alumno.fNacimiento }" />
					<fmt:formatDate type='date' pattern='y' value='${fecha}' var="year" />
					<fmt:formatDate type='date' pattern='M' value='${fecha}' var="month" />
					<fmt:formatDate type='date' pattern='d' value='${fecha}' var="day" />

					<div class="form-group">
						<label>FECHA NACIMIENTO: </label>
						<div class="form-inline">
							<input type="number" class="form-control" min="1" max="31" name="${properties.parDia }"
								value="${day }" />/ <input type="number" class="form-control" min="1" max="12"
								name="${properties.parMes }" value="${month }" /> / <input type="number"
								class="form-control" min="1950" max="2016" name="${properties.parYear }" value="${year }" />
						</div>
					</div>
					<div class="form-group">
						<c:set var="generos" value="<%=Genero.values()%>" />
						<div class="form-inline">
							<label>GENERO: </label>
							<c:forEach items="${generos}" var="genero">
								<input type="radio" class="form-control" name="${properties.parGenero}"
									value="${genero.codigo}" ${(genero eq alumno.genero) ? 'checked' : '' } />	${genero.valor}
							</c:forEach>
						</div>
					</div>
				</fieldset>
			</div>
			<div class="col-xs-6">
				<fieldset>
					<legend>Datos de Contacto</legend>
					<div class="form-inline">
						<div class="form-group">
							<label for="${properties.parEmail}">E-MAIL: </label>
							<div class="input-group">
								<span class="input-group-addon" id="sizing-addon1"><i class="fa fa-envelope"
									aria-hidden="true"></i></span> <input type="email" id="${properties.parEmail}"
									name="${properties.parEmail}" class="form-control" placeholder="example@mail.com"
									aria-describedby="sizing-addon1" value="${alumno.email }">
							</div>
						</div>
						<div class="form-group">
							<label for="${properties.parTelefono}">TELEFONO: </label>
							<div class="input-group">
								<span class="input-group-addon" id="sizing-addon2"><i class="fa fa-phone"
									aria-hidden="true"></i></span> <input type="text" id="${properties.parTelefono}"
									name="${properties.parTelefono}" class="form-control" aria-describedby="sizing-addon2"
									value="${alumno.telefono }">
							</div>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>Datos Adicionales</legend>
					<div class="form-group">
						<div class="form-inline">
							<c:set var="idiomas" value="<%=Idioma.values()%>" />
							<label>IDIOMAS: </label>
							<c:forEach items="${idiomas}" var="idioma">
								<input type="checkbox" class="form-control" name="${properties.parIdiomas}"
									value="${idioma.codigo }" />
							${idioma.nombre }
							</c:forEach>

						</div>
					</div>
				</fieldset>
				<div class="form-inline">
					<div class="form-group">
						<a href="${properties.servletAlumno }" class="btn btn-danger"><i class="fa fa-times fa-2x"></i></a>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success">
							<i class="fa fa-check fa-2x"></i>
						</button>
					</div>
				</div>

			</div>



		</form>

	</div>
</div>
</main>
<%@ include file="../includes/footer.jsp"%>