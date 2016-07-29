<%@page import="java.util.Map"%>
<%@page import="com.ipartek.formacion.pojo.Modulo"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.pojo.TipoCurso"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<%
  Curso curso = (Curso) request.getAttribute(Constantes.ATT_CURSO);
  int op = -1;
  if (curso != null) {
    op = Constantes.OP_UPDATE;

  } else {

    curso = new Curso();
    op = Constantes.OP_CREATE;
  }
%>
<main>
<div class="row">

	<div class="col-xs-12">
		<form name="formulario" id="formulario" method="POST" action="<%=Constantes.SERVLET_CURSOS%>">
			<div class="col-xs-12 col-md-6">
				<input type="hidden" id="${properties.parCodigo}>" name="${properties.parCodigo}"
					value="<%=curso.getCodigo()%>" /> <input type="hidden" id="${properties.parOperacion}"
					name="${properties.parOperacion}" value="<%=op%>" />
				<fieldset>
					<legend>Datos del Curso</legend>
					<div class="form-group">
						<label for="${properties.parCodPatrocinador}">CODIGO PATROCINADOR: </label> <input type="text"
							class="form-control" name="${properties.parCodPatrocinador}" id="${properties.parCodPatrocinador}"
							value="<%=curso.getCodigoPatrocinador()%>" />
					</div>
					<div class="form-group">
						<label for="${properties.parNombre}">NOMBRE: </label> <input type="text" class="form-control"
							name="${properties.parNombre}" id="${properties.parNombre}" value="<%=curso.getNombre()%>" />
					</div>
					<div class="form-group">
						<label for="${properties.parTipo}">TIPO CURSO: </label> <select class="form-control"
							name="${properties.parTipo}" id="${properties.parTipo}">
							<option value="<%=Curso.CODIGO_CURSO%>">-- Seleccione un tipo --</option>
							<%
							  for (TipoCurso tipo : TipoCurso.values()) {
							%>
							<option <%=(curso.getTipo() == tipo) ? "selected" : ""%> value="<%=tipo.getCodigo()%>"><%=tipo.getTipo()%>
							</option>
							<%
							  }
							%>
						</select>
					</div>
				</fieldset>
			</div>
			<div class="col-xs-12">
				<div class="form-inline">
					<div class="form-group">
						<a href="${properties.servletCurso}" class="btn btn-danger">Cancelar</a>
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