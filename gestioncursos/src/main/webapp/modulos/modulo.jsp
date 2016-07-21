<%@page import="com.ipartek.formacion.pojo.Duracion"%>
<%@page import="com.ipartek.formacion.pojo.Modulo"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<%
  Modulo modulo = (Modulo) request.getAttribute(Constantes.ATT_MODULO);
  int op = -1;
  if (modulo != null) {
    op = Constantes.OP_UPDATE;
%><title>Modulo <%=modulo.getNombre()%></title>
<%
  } else {
%><title>Modulo - Modulo nuevo</title>
<%
  modulo = new Modulo();
    op = Constantes.OP_CREATE;
  }
%>

<main>
<div class="row">
	<div class="col-xs-12">
		<form name="formulario" id="formulario" method="POST" action="<%=Constantes.SERVLET_MODULOS%>">
			<div class="col-xs-6">
				<input type="hidden" id="${properties.parCodigo}" name="${properties.parCodigo}"
					value="<%=modulo.getCodigo()%>" /> <input type="hidden" id="${properties.parOperacion}"
					name="${properties.parOperacion}" value="<%=op%>" />				
				<div class="form-group">
					<label for="${properties.parNombre}">NOMBRE: </label> <input type="text"
						class="form-control" name="${properties.parNombre}" id="${properties.parNombre}"
						value="<%=modulo.getNombre()%>" />
				</div>
				<div class="form-group">
					<label for="${properties.parUFormativa}">UNIDAD FORMATIVA: </label> <input type="text"
						class="form-control" name="${properties.parUFormativa}" id="${properties.parUFormativa}"
						value="<%=modulo.getuFormativa()%>" />
				</div>
				<div class="form-group">
					<label for="${properties.parDuracion}">DURACIÓN: </label> <select class="form-control"
						name="${properties.parDuracion}" id="${properties.parDuracion}">
						<option <%=(modulo.getDuracion() == 20) ? "selected" : ""%> value="20">20</option>
						<option <%=(modulo.getDuracion() == 45) ? "selected" : ""%> value="45">45</option>
						<option <%=(modulo.getDuracion() == 80) ? "selected" : ""%> value="80">80</option>
						<option <%=(modulo.getDuracion() == 90) ? "selected" : ""%> value="90">90</option>
					</select>
				</div>
			</div>
			<div class="col-xs-12">
				<div class="form-inline">
					<div class="form-group">
						<a href="<%=Constantes.SERVLET_MODULOS%>" class="btn btn-danger">Cancelar</a>
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