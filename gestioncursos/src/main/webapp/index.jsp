<%@page import="java.util.Properties"%>
<%@page import="com.ipartek.formacion.service.Util"%>
<%@page import="com.ipartek.formacion.service.Idiomas"%>
<%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="includes/header.jsp"/>
	
<main>
<div class="col-xs-12 col-md-9">
	<h3>Listado de Cursos Emitidos</h3>
	
	<c:set var="listado" value="${sessionScope[properties.listadoCursosEmitidos]}"/>
	<c:if test="${!empty listado }">
		<div class="panel-group">
			<c:forEach items="${listado}" var="cursoAlumno">
				<div class="panel panel-default">
		      		<div class="panel-heading">${cursoAlumno.codigoPatrocinador} - ${cursoAlumno.referencia}</div>
		      		<div class="panel-body">
		      			<p>Nombre Curso: ${cursoAlumno.nombre}</p>
		      			<p>Fecha Inicio: ${cursoAlumno.fInicio.time==Long.MIN_VALUE ? "Fecha no fijada" : ""}</p>
		      			<p>Fecha Fin: ${empty cursoAlumno.fechaFin ? "Fecha no fijada" : ""}</p>
		      			<p>Tipo Curso: ${cursoAlumno.tipo.tipo}</p>
		      		</div>
		    	</div>
	    	</c:forEach>
		</div>
	</c:if>
</div>
	
	<%
	Usuario usuario = (Usuario)session.getAttribute(Constantes.ATT_USUARIO);
	
	if(usuario==null){
		
	%>
	
	<div class="row">
	<div class="col-md-4 col-md-offset-7">
	<jsp:include page="includes/mensaje.jsp"/>
     <div class="panel panel-default">
     	<div class="panel-heading"> <strong class="">Login</strong>
		 </div>
		 <div class="panel-body">
		<form class="form-horizontal" name="formu_login" method="post" action="<%=Constantes.SERVLET_LOGIN%>">
			<div class="form-group">
			<div class="col-sm-3">	
				<label for="<%=Constantes.PAR_ALIAS%>">USUARIO:</label>
				</div>
				<div class="col-sm-7">
				<c:set var="userName" value="${cookie.alias}" />
				<input type="text" class="form-control" 
					id="<%=Constantes.PAR_ALIAS%>" 
					name="<%=Constantes.PAR_ALIAS%>" 
					value="${userName.value}"/>
				</div>
			</div>
			
			<div class="form-group">
			<div class="col-sm-3">	
				<label for="<%=Constantes.PAR_PASSWORD%>">CONTRASEÑA:</label>
			</div>
				<div class="col-sm-7">
				<input type="text" class="form-control" 
					id="<%=Constantes.PAR_PASSWORD%>" 
					name="<%=Constantes.PAR_PASSWORD%>" 
					value=""/>
				</div>
			</div>
			
			<div class="form-group">
			<div class="col-sm-3">	
				<label for="<%=Constantes.PAR_IDIOMA%>">IDIOMA:</label>
			</div>
				<div class="col-sm-7">
				<select class="form-control" name="<%=Constantes.PAR_IDIOMA%>">
						<c:set var="idiomas" value="<%=Idiomas.values() %>"/>
						<option>Selecciona un idioma</option>
			     		 <c:forEach items="${idiomas}" var="idioma">
				        <c:if test="${idioma != selected}">
				            <option value="${idioma.codigo}">${idioma.nombre}</option>
				        </c:if>
				    </c:forEach>
			    </select>
				</div>
			</div>
			
			
			<div class="input-form">
				<input id="<%=Constantes.PAR_REMEMBER%>" 
					name="<%=Constantes.PAR_REMEMBER%>" 
					type="checkbox" value="1"><label for="<%=Constantes.PAR_REMEMBER%>">Recuerdame</label> 
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<button type="submit" class="btn btn-success">Entrar</button>
				</div>
			</div>	
		</form>
	</div>
	</div>
	</div>
	</div>
	<%}
	%>
</main>
<%@ include file="includes/footer.jsp" %> 