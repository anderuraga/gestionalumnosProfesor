<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/resources/css/bootstrap.min.css" var="cssBootstrap" />
<spring:url value="css/font-awesome.min.css" var="cssFont" />
<spring:url value="css/styles.css" var="cssStyle"/>
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
<script src="js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">
	<header class="row">
		<h1>Gestión Alumnos</h1>
	</header>
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href="home.jsp">Inicio</a>
		</div>
		<div class="navbar navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href=>Alumnos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/alumnos"/>'>Listado de alumnos</a></li>
						<li><a>Crear nuevo alumno</a></li>
					</ul></li>
			</ul>
			<ul class="navbar navbar-collapse navbar-ex1-collapse">
				<li class="dropdown"><a>Cursos</a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value = "/cursos"/>"> Listado de cursos</a></li>
						<li><a>Crear nuevo curso</a></li>
					</ul></li>
			</ul>
			<ul>
				<li class="dropdown"><a>Modulos</a>
					<ul class="dropdown-menu">
						<li><a href="modulos/listado">Listado de modulos</a></li>
						<li><a>Crear nuevo modulo</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>