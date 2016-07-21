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
			<div class="col-xs-12 col-md-6">
				<fieldset>
					<legend>
						Alumnos <small class="pull-right">(Total inscritos <span class="label label-primary"><%=curso.getAlumnos().size()%></span>)
						</small>
					</legend>
					<div class="form-group">
						<div class="form-inline">
							<%
							  List<Alumno> alumnos = (List<Alumno>) request.getAttribute(Constantes.ATT_LISTADO_ALUMNOS);

							  if (alumnos != null) {
							    for (Alumno alumno : alumnos) {
							%>
							<div class="col-xs-6">
								<div class="checkbox">
									<label> <input type="checkbox" name="${properties.parAlumnos}"
										id="${properties.parAlumnos}" value="<%=alumno.getCodigo()%>"
										<%=curso.getAlumnos().containsKey(alumno.getDni()) ? "checked" : ""%> /> <%=alumno.getNombre()%>
									</label>
								</div>
							</div>
							<%
							  }
							  }
							%>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>
						Modulos<small class="pull-right">(Total modulos <span class="label label-primary"><%=curso.getModulos().size()%></span>)
						</small></legend>
					<div class="form-inline">
						<%
						  int nHoras = 0;
						  List<Modulo> modulos = (List<Modulo>) request.getAttribute(Constantes.ATT_LISTADO_MODULOS);
						  
						  if (modulos != null)
						    for (Modulo modulo : modulos) {
						      boolean esta = false;
						      if (curso.getModulos().containsKey(modulo.getCodigo())) {
						        esta = true;
						        nHoras += modulo.getDuracion();
						      }
						%>

						<div class="col-xs-6">
							<div class="checkbox">
								<label> <input type="checkbox" name="${properties.parModulos}"
									id="${properties.parModulos}" value="<%=modulo.getCodigo()%>" <%=esta ? "checked" : ""%> />
									<%=modulo.getNombre()%>
								</label>
							</div>
						</div>
						<%
						  }
						%>
					</div>
					<div class="form-group">
						<p><label>DURACION DEL CURSO:</label> <%=nHoras%> Horas</p>
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