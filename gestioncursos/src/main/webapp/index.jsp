<%@page import="java.util.Properties"%>
<%@page import="com.ipartek.formacion.pojo.Idioma"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />
<main class="container-fluid">
<div class="row">
	<div class="col-xs-12">
		<jsp:include page="includes/mensaje.jsp" />
	</div>
	<div class=" col-md-9">
		<h3>Listado de los cursos emitidos</h3>
		<%
		Properties props = (Properties)getServletContext().getAttribute("properties");
		%>
		<!-- Guarda el lugar donde esta alojada la lista -->
		<c:set var="nVariable" value="${properties.listadoCursosEmitidos }" />
		<c:set var="listado" value="sessionScope[nVariable]" />
	</div>
	<aside class="col-xs-12 col-md-5 panel">
		<jsp:include page="includes/mensaje.jsp" />
		<div class="panel panel-success">

			<div class="panel-heading">
				<div class="panel-title">
					<h2>Login</h2>
				</div>

			</div>

			<div class="panel-body">
				<form class="form-horizontal"
					action="<%=Constantes.SERVLET_LOGIN%>" method="post" role="form">
					<div class="input-group">
						<label class="sr-only" for="<%=Constantes.PAR_USERNAME%>">Usuario</label><span
							class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input
							id="<%=Constantes.PAR_USERNAME%>"
							name="<%=Constantes.PAR_USERNAME%>" type="text"
							class="form-control" value="" placeholder="Introduzca su usuario">

					</div>
					<div class="input-group">
						<label class="sr-only" for="<%=Constantes.PAR_PASSWORD%>">Contraseña:</label>
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input
							name="<%=Constantes.PAR_PASSWORD%>"
							id="<%=Constantes.PAR_PASSWORD%>" type="password"
							class="form-control" placeholder="Introduzca su contraseña">
					</div>
					<div>
						<label class="sr-only" for="<%=Constantes.PAR_IDIOMA%>">Idioma</label>
						<select name="<%=Constantes.PAR_IDIOMA%>" id="<%=Constantes.PAR_IDIOMA%>">
						<c:set var="idiomas" value="<%=Idioma.values()%>"/> <!-- Declarar variable con JSTL -->
							<c:forEach items="${idiomas}" var="idioma">
								<option value="${idioma.codigo}">${idioma.nombre}</option>
							</c:forEach>
						</select>
					</div>
					<div class="input-group">
						<div class="checkbox">
							<input type="checkbox" value="1"
								id="<%=Constantes.PAR_REMEMBER%>"
								name="<%=Constantes.PAR_REMEMBER%>"><label for="">Recuerdame</label>
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
</div>
</main>
<%@ include file="includes/footer.jsp"%>








