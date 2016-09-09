<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<spring:url value="/resources/css/bootstrap.min.css" var="cssBootstrap" />
<spring:url value="/resources/css/font-awesome.min.css" var="cssFont" />
<spring:url value="/resources/css/styles.css" var="cssStyle" />
<spring:url value="/resources/js/bootstrap.min.js" var="jsBootstrap" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
			<a class="nav navbar-brand" href="alumnos">Inicio</a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Desplegar navegación</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle" data-toggle="dropdown" href='<c:url value="/alumnos/"/>'>Alumnos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/alumnos"/>'>Alumnos</a></li>
						<li><a href='<c:url value="/alumnos/saveAlumno"/>'>Crear Alumno</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle" data-toggle="dropdown" href='<c:url value = "/cursos/"/>'>Cursos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value = "/cursos"/>'>Cursos</a></li>
						<li><a>Crear Curso</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle" data-toggle="dropdown" href='<c:url value = "/modulos/"/>'>Modulos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/modulos/" />'>Módulos</a></li>
						<li><a>Crear Módulo</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
<main>
	<form:form action="saveCurso" commandName="curso">
		<c:if test="${curso.codigo >0}">
			<div class="row">
				<div class="cl-xs-6">
					<form:label path="codigo">
						<spring:message text="Codigo"/>
					</form:label>
					<form:input path="codigo" readonly="true" size="10" disabled=""/>
					<form:hidden path="codigo" />
				</div>
			</div>
		</c:if>
		<div class="row">
			<div class="col-xs-6">
				<form:label path="nombre">
					<spring:message text="Nombre"/>
				</form:label>
				<form:input path="nombre" size="10" disabled="" />
				<form:hidden path="nombre" />
			</div>
		</div>
		<c:if test="${curso.codigo > 0}">
			<input type="submit" value="<spring:message text="Editar curso"/>"/>
		</c:if>
		<c:if test="${curso.codigo < 0}">
			<input type="submit" value="<spring:message text="Crear curso"/>"/>
		</c:if>
	</form:form>
</main>
</body>
</html>
