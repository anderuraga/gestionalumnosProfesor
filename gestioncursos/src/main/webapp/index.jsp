<%@page import="com.ipartek.formacion.pojo.CursoAlumnos"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Properties"%>
<%@page import="com.ipartek.formacion.pojo.Idioma"%>
<%@page import="com.ipartek.formacion.pojo.Mensaje"%>
<%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="includes/header.jsp" />
<main>
<div class="row">
	<div class="col-xs-12">
		<jsp:include page="includes/mensaje.jsp" />
	</div>
	<div class="col-xs-12 col-md-9">
		<h3>Listado de Cursos Emitidos</h3>
		<%
		Properties props = (Properties)getServletContext().getAttribute("properties");
		List<CursoAlumnos> listado = (List<CursoAlumnos>)session.getAttribute(props.getProperty("listadoCursosEmitidos"));
		%>
		<c:set var="nVariable" value="${properties.listadoCursosEmitidos}" />
		<c:set var="listado" value="${sessionScope[properties.listadoCursosEmitidos]}" />
		<c:if test="${!empty listado}">
		<div class="panel-group ">
			<c:forEach items="${listado}" var="cursoAlumno">
			<div class="panel panel-info">
		      <div class="panel-heading">${cursoAlumno.codigoPatrocinador} - ${cursoAlumno.referencia}</div>
		      <div class="panel-body">
		      	<p>Nombre Curso: ${cursoAlumno.nombre}</p> 	
		      	<p>Fecha Inicio: ${cursoAlumno.fInicio.time==Long.MIN_VALUE ? "Fecha no fijada" : "" }</p>
		      	<p>Fecha Fin: ${empty cursoAlumno.fFin ? "Fecha no fijada" : ""}</p>
		      	<p>Tipo Curso: ${cursoAlumno.tipo.tipo}</p>
		      </div>
			</div>
			</c:forEach>
		</div>
		</c:if>
	</div>
	<%
	  Usuario user = (Usuario) session.getAttribute(Constantes.ATT_USUARIO);
	  if (user == null) {
	%>
	<aside class="col-xs-12 col-md-3">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h2 class="panel-title">Login</h2>
			</div>
			<div class="panel-body">
				<form method="POST" action="${properties.servletLogin}">
					<div class="form-group">
						<c:set var="userName" value="${cookie.usuario }" />
						<input type="text" class="form-control" name="${properties.parUsername}" placeholder="Usuario"
							value="${userName.value }" />
					</div>
					<div class="form-group">
						<c:set var="password" value="${cookie.password }" />
						<input type="password" class="form-control" name="${properties.parPassword}"
							placeholder="Contraseña" value="${password.value }" />
					</div>
					<jsp:include page="includes/error.jsp" />


					<div class="form-group">
						<div class="checkbox">
							<label> <input type="checkbox" name="${properties.parRecuerda}" checked />Recuerdame
							</label>
						</div>
					</div>
					<div class="form-group">
						<c:set var="idiomas" value="<%=Idioma.values()%>" />
						<select name="${properties.parLocale}" id="${properties.parLocale}" class="form-control">
							<option selected>Idioma (Por defecto)</option>
							<c:forEach items="${idiomas}" var="idioma">
						
								<option value="${idioma.codigo}">${idioma.nombre}</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-primary center-block">Iniciar Sesión</button>
					</div>
				</form>

			</div>
		</div>
	</aside>
	<%
	  }
	%>
</div>
</main>
<%@ include file="includes/footer.jsp"%>