<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
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
			<a class="nav navbar-brand" href="/alumnos/">Inicio</a>
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
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value="/alumnos/"/>'>Alumnos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/alumnos"/>'>Alumnos</a></li>
						<li><a href='<c:url value="/alumnos/addAlumno"/>'>Crear
								Alumno</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value = "/cursos/"/>'>Cursos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value = "/cursos"/>'>Cursos</a></li>
						<li><a>Crear Curso</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle"
					data-toggle="dropdown" href='<c:url value = "/modulos/"/>'>Módulos</a>
					<ul class="dropdown-menu">
						<li><a href='<c:url value="/modulos/" />'>Módulos</a></li>
						<li><a>Crear Módulo</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
<main>
<!-- 	<div class="row"> -->
<!-- 		<div class="col-xs-4"> -->
<!-- 			<a class="btn btn-success" href="/addAlumnos">Crear Alumno</a> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
	
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<%
					List<Alumno> alumnos = (List<Alumno>) request.getAttribute("listado-alumnos");
					if (alumnos.size() > 0) {
						for (Alumno a : alumnos) {
				%> <a href="<c:url value="/alumnos/${alumno.codigo}" />">
				<%
					
				out.print("<p>" + a.getNombre() + " " + a.getApellidos() + " </a>    <a class='btn btn-default' href='<c:url value='/alumnos/${alumno.codigo}' />'>Modificar Alumno</a></p>");
				
			 		}
			 		} else {
				 %>
					<p>No se han encontrado alumnos en la BB.DD.</p>
				<%
				}
				%> 
			</div>
		</div>
	</div>
</main>
</body>
</html>