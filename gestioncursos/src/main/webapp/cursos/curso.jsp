<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.Map"%>
<%@page import="com.ipartek.formacion.pojo.Modulo"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.pojo.TipoCurso"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<c:choose>
	<c:when test="${!empty curso}">
		<c:set var="operacion" value="${properties.opUpdate}" />
	</c:when>
	<c:otherwise>
		<c:set var="curso" value="<%=new Curso()%>" />
		<c:set var="operacion" value="${properties.opCreate }" />
	</c:otherwise>
</c:choose>
<main>
<div class="row">
	<div class="col-xs-12">
		<form name="formulario" id="formulario" method="POST" action="${properties.servletCurso}">
			<div class="col-xs-12 col-md-6">
				<input type="hidden" id="${properties.parCodigo}>" name="${properties.parCodigo}"
					value="${curso.codigo}" /> <input type="hidden" id="${properties.parOperacion}"
					name="${properties.parOperacion}" value="${operacion }" />
				<fieldset>
					<legend>Datos del Curso</legend>
					<div class="form-group">
						<label for="${properties.parCodPatrocinador}">CODIGO PATROCINADOR: </label> <input type="text"
							class="form-control" name="${properties.parCodPatrocinador}"
							id="${properties.parCodPatrocinador}" value="${curso.codigoPatrocinador }" />
					</div>
					<div class="form-group">
						<label for="${properties.parNombre}">NOMBRE: </label> <input type="text" class="form-control"
							name="${properties.parNombre}" id="${properties.parNombre}" value="${curso.nombre }" />
					</div>
					<div class="form-group">
						<c:set var="tipos" value="<%=TipoCurso.values()%>" />
						<label for="${properties.parTipo}">TIPO CURSO: </label> <select class="form-control"
							name="${properties.parTipo}" id="${properties.parTipo}">
							<option value="<%=Curso.CODIGO_CURSO%>">-- Seleccione un tipo --</option>
							<c:forEach items="${tipos}" var="tipo">
								<option ${(curso.tipo eq tipo) ? 'selected' : ''} value="${tipo.codigo }">${tipo.tipo }
								</option>
							</c:forEach>
						</select>
					</div>
				</fieldset>
			</div>
			<div class="col-xs-12 col-md-6">
				<fieldset>
					<legend>
						Alumnos <small class="pull-right">(Total inscritos <span class="label label-primary">0</span>)
						</small>
					</legend>
					<div class="form-group">
						<div class="form-inline">
							<c:forEach items="${listado_alumnos}" var="alumno">
								<div class="col-xs-6">
									<div class="checkbox">
										<label> <input type="checkbox" name="${properties.parAlumnos}"
											id="${properties.parAlumnos}" value="${alumno.codigo}" /> ${alumno.nombre}
										</label>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</fieldset>
				<fieldset>
					<legend>
						Modulos<small class="pull-right">(Total modulos <span class="label label-primary">0</span>)
						</small>
					</legend>
					<div class="form-inline">
						<div class="form-inline">
							<c:forEach items="${listado_modulos}" var="modulo">
								<div class="col-xs-6">
									<div class="checkbox">
										<label> <input type="checkbox" name="${properties.parAlumnos}"
											id="${properties.parAlumnos}" value="${modulo.codigo}" /> ${modulo.nombre}
										</label>
									</div>
								</div>
							</c:forEach>
						</div>
						<div class="form-group">
							<p>
								<label>DURACION DEL CURSO:</label>0 Horas
							</p>
						</div>
					</div>
				</fieldset>
				<div class="form-inline">
					<div class="form-group">
						<a href="${properties.servletCurso}" class="btn btn-danger"><i class="fa fa-times fa-2x"></i></a>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success"><i class="fa fa-check fa-2x"></i></button>
					</div>
				</div>
			</div>
		</form>

	</div>
</div>
</main>
<%@ include file="../includes/footer.jsp"%>