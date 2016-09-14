<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Modulo"%>
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

	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<%
					List<Modulo> modulos = (List<Modulo>) request
							.getAttribute("listado-modulos");
					if (modulos.size() > 0) {
						for (Modulo a : modulos) {
				%>
				<div class="table-responsive">
					<table class="table">
						<tr>
							<td><%=a.getNombre() %></td>							
							<td></td>
							<td><a href="modulos/<%=a.getCodigo()%>"
								class="btn btn-default">Modificar Modulo</a></td>
								<td><form action="delete/modulos/<%=a.getCodigo()%>" method="post">
								<BUTTON class="btn btn-default">Borrar Modulo</BUTTON></form></td>
							<%
								}
								} else {
							%>
							<td>No se han encontrado modulos en la BB.DD.</td>
							<%
								}
							%>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	</main>
</body>
</html>