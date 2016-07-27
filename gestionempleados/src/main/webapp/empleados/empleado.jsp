<%@page import="java.util.Properties"%>
<%@page import="com.ipartek.formacion.pojo.Departamento"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.pojo.Idioma"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<%
  Empleado empleado = (Empleado) request.getAttribute(Constantes.ATT_EMPLEADO);
  int op = -1;
  if (empleado != null) {
    op = Constantes.OP_UPDATE;
  } else {
    empleado = new Empleado();
    op = Constantes.OP_CREATE;
  }
%>
<main>

<div class="row">
	<div class="col-xs-12">
		<form name="formulario" id="formulario" method="POST" action="${properties.servletEmpleado }">
			<div class="col-xs-6">
				<input type="hidden" id="${properties.parCodigo}" name="${properties.parCodigo}"
					value="${empleado.codigo }" /> <input type="hidden" id="${properties.parOperacion}"
					name="${properties.parOperacion}" value="<%=op%>" />
				<fieldset>
					<legend>Datos Personales</legend>
					<div class="form-group">
						<label for="${properties.parNombre}">NOMBRE: </label> <input type="text" class="form-control"
							name="${properties.parNombre}" id="${properties.parNombre}" value="${empleado.nombre }" />

					</div>
					<div class="form-group">
						<label for="${properties.parApellidos }">APELLIDOS: </label> <input type="text"
							class="form-control" name="${properties.parApellidos }" id="${properties.parApellidos }"
							value="${empleado.apellidos }" />
					</div>
					<div class="form-group">
						<label for="${properties.parDni }">DNI: </label> <input type="text" required
							class="form-control"
							pattern="(([X-Z]{1})([-]?)(\d{7})([-]?)([A-Z]{1}))|((\d{8})([-]?)([A-Za-z]{1}))"
							name="${properties.parDni }" id="${properties.parDni }" value="${empleado.dni }" />
					</div>
					<%
					  Date date = empleado.getfNacimiento();
					  GregorianCalendar calendar = new GregorianCalendar();
					  calendar.setTime(date);
					%>
					<div class="form-group">
						<label for="${properties.parMes }">FECHA NACIMIENTO: </label>
						<div class="form-inline">
							<input type="number" class="form-control" min="1" max="31" name="${properties.parDia }"
								value="<%=calendar.get(GregorianCalendar.DAY_OF_MONTH)%>" />/ <input type="number"
								class="form-control" min="1" max="12" name="${properties.parMes }"
								value="<%=calendar.get(GregorianCalendar.MONTH) + 1%>" /> / <input type="number"
								class="form-control" min="1950" max="2016" name="${properties.parAnyo }"
								value="<%=calendar.get(GregorianCalendar.YEAR)%>" />
						</div>
					</div>
					
				</fieldset>
			</div>

			<div class="col-xs-12">
				<div class="form-inline">
					<div class="form-group">
						<a href="${properties.servletEmpleado }" class="btn btn-danger">Cancelar</a>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Enviar</button>
					</div>
				</div>
			</div>


		</form>

	</div>
</div>
</main>
<%@ include file="../includes/footer.jsp"%>