<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Properties"%>
<%@page import="com.ipartek.formacion.pojo.CursoAlumnos"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
<main> Bienvenidos a la página de Gestión de Alumnos de Ipartek <%
	String tEnviar = "Enviar";
%>
<aside class="col-xs-12 col-md-5 panel">
	<jsp:include page="includes/mensaje.jsp" />
	<div class="col-xs-12 col-md-9">

		<h3>Listado de Cursos Emitidos</h3>

		<%
			Properties props = (Properties) getServletContext().getAttribute("properties");
			List<CursoAlumnos> listado = (List<CursoAlumnos>) session
					.getAttribute(props.getProperty("listadoCursosEmitidos"));
		%>
		<c:set var="nVariable" value="${properties.listadoCursosEmitidos}" />
		<c:set var="listado"
			value="${sessionScope[properties.listadoCursosEmitidos]}" />
		<c:if test="${!empty listado}">

			<div>
				<div class="panel-group">
					<c:forEach items="${listado }" var="cursoAlumno">
						<div class="panel panel-default">
							<div class="panel-heading">${cursoAlumno.codPatrocinador} - ${cursoAlumno.referencia }</div>
							<div class="panel-body">
							<p></p>
								<p>Nombre Curso: ${cursoAlumno.nombre }</p>
								<p>Fecha Inicio:  ${cursoAlumno.fInicio.getTime==Long.MIN_VALUE }?"fecha no fijada":"fecha"</p>
								<p>Fecha Fin:${empty cursoAlumno.fFin}?"fecha no fijada":"fecha"</p>
								<p>Tipo de Curso: ${cursoAlumno.tipo.tipo }</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:if>


	</div>

	<div class="panel panel-success">

		<div class="panel-heading">
			<div class="panel-title">
				<h2>Login</h2>
			</div>

		</div>

		<div class="panel-body">
			<form class="form-horizontal" action="<%=Constantes.SERVLET_LOGIN%>"
				method="post" role="form">
				<div class="input-group">
					<label class="sr-only" for="<%=Constantes.PAR_USER%>">Usuario</label><span
						class="input-group-addon"><i
						class="glyphicon glyphicon-user"></i></span> <input
						id="<%=Constantes.PAR_USER%>" name="<%=Constantes.PAR_USER%>"
						type="text" class="form-control" value=""
						placeholder="Introduzca su usuario">

				</div>
				<div class="input-group">
					<label class="sr-only" for="<%=Constantes.PAR_PASSWORD%>">Contraseña:</label>
					<span class="input-group-addon"><i
						class="glyphicon glyphicon-lock"></i></span> <input
						name="<%=Constantes.PAR_PASSWORD%>"
						id="<%=Constantes.PAR_PASSWORD%>" type="password"
						class="form-control" placeholder="Introduzca su contraseña">
				</div>
				<div class="input-group">
					<div class="checkbox">
						<label> </label> <input type="checkbox"
							name="<%=Constantes.PAR_REMEMBER%>"
							id="<%=Constantes.PAR_REMEMBER%>" value="1"> Recuerdame
					</div>
				</div>


				<div class="form-group">
					<div class="col-xs-12 controls">
						<button type="submit" id="btn-login" class="btn btn-success">Aceptar
						</button>


					</div>
				</div>
			</form>
		</div>
		<!--panel-body-->
	</div>
</aside>




</main>
<%@ include file="includes/footer.jsp"%>