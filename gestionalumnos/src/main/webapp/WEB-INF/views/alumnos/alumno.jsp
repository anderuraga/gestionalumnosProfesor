<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<spring:url value="/resources/css/bootstrap.min.css" var="cssBootstrap" />
<spring:url value="/resources/css/font-awesome.min.css" var="cssFont" />
<spring:url value="/resources/css/styles.css" var="cssStyle" />
<spring:url value="/resources/js/bootstrap.min.js" var="jsBootstrap" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gestión Alumnos</title>
<!-- CARGAMOS LOS BASICOS DE BOOTSTRAP -->
<link rel="stylesheet" href="${cssBootstrap}" />
<!-- CARGAMOS LAS FUENTES -->
<link rel="stylesheet" href="${cssFont}">
	<!-- CARGAMOS NUESTROS ESTILOS -->
<link rel="stylesheet" href="${cssStyle}">
	<!-- CARGAMOS JQUERY -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- CARGAMOS LAS LIBRERIAS JS DE BOOTSTRAP -->
<script src="${jsBootstrap}"></script>
</head>

<body class="container-fluid">
	<header class="row">
		<h1>Gestión Alumnos</h1>
	</header>
	<nav class="navbar" role="navigation">
		<div class="navbar-header">
			<a class="nav navbar-brand" href='<c:url value="/alumnos"/>'>Inicio</a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Desplegar navegación</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value="/alumnos/"/>'>Alumnos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/alumnos"/>'>Alumnos</a></li>
						<li><a href='<c:url value="/alumnos/addAlumno"/>'>Crear
								Alumno</a></li>
						<li><a href='<c:url value="/alumnos/restclients"/>'>Página
								RestClient</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value = "/cursos/"/>'>Cursos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value = "/cursos"/>'>Cursos</a></li>
						<li><a href='<c:url value="/cursos/addCurso"/>'>Crear
								Curso</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value = "/modulos/"/>'>Módulos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/modulos" />'>Módulos</a></li>
						<li><a href='<c:url value="/modulos/addModulo"/>'>Crear
								Módulo</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
	<!-- Hasta aquí todo el encabezado -->
	
	<main> 
	<div class="col-sm-6">
		<form:form action="saveAlumno" commandName="alumno" method="post">
			<c:if test="${alumno.codigo > 0 }">
				<form:label path="codigo">
					<spring:message text="alumno.codigo" />
				</form:label>
				<form:input path="codigo" readonly="true" size="10" disabled="true" />
				<form:hidden path="codigo" />
			</c:if>
			<div>
				<div class="form-group">
					<form:label path="nombre">
						<spring:message text="Nombre: " />
					</form:label>
					<form:input path="nombre" cssErrorClass="" cssClass="" />
					<form:errors cssClass="" path="nombre" />
				</div>
				<div class="form-group">
					<form:label path="apellidos">
						<spring:message text="Apellidos: " />
					</form:label>
					<form:input path="apellidos" cssClass="" cssErrorClass="" />
					<form:errors cssClass="" path="apellidos" />
				</div>
				<div class="form-group">
					<form:label path="fNacimiento" cssClass="" cssErrorClass="">
						<spring:message text="Fecha de Nacimiento: " />
					</form:label>
					<form:input path="fNacimiento" placeholder="dd/MM/yyyy" />
					<form:errors cssClass="" />
				</div>
				<div class="form-group">
					<form:label path="dni" cssClass="" cssErrorClass="invalid">
						<spring:message text="D.N.I.:" />
					</form:label>
					<form:input path="dni" />
								<form:errors cssClass="" path="dni"/>
				</div>


				<div class="form-group">
					<c:if test="${alumno.codigo>0}">
						<input type="submit"
							value="<spring:message text="Editar Alumno"/>" />
					</c:if>
					<c:if test="${alumno.codigo<0}">
						<input type="submit" value="<spring:message text="Crear Alumno"/>" />
					</c:if>
				</div>
			</div>
		</form:form>
	</div>
	</main>
	</div>
</body>
</html>