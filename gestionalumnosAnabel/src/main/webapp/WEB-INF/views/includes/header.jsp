<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<div class="row">
		<div class="col-xs-12">
			<header>
				<h1>Gestión Alumnos</h1>
			</header>
		</div>
	</div>
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Desplegar navegación</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="nav navbar-brand" href='<c:url value=""/>'>Inicio</a>
		</div>
		<div class="navbar navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value="/alumnos/"/>'>Alumnos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/alumnos"/>'>Listado de
								alumnos</a></li>
						<li><a href='<c:url value="/alumnos/addAlumnos"/>'>Crear
								nuevo alumno</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value = "/cursos/"/>'>Cursos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value = "/cursos"/>'> Listado de
								cursos</a></li>
						<li><a href='<c:url value="/cursos/addCursos"/>'>Crear nuevo curso</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value = "/modulos/"/>'>Modulos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/modulos/" />'>Listado de
								modulos</a></li>
						<li><a href='<c:url value="/modulos/addModulos"/>'>Crear nuevo modulo</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>