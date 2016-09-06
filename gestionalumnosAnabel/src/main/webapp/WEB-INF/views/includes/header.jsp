<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión Alumnos</title>
<!-- CARGAMOS LOS BASICOS DE BOOTSTRAP -->
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<!-- CARGAMOS LAS FUENTES -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- CARGAMOS NUESTROS ESTILOS -->
<link rel="stylesheet" href="css/styles.css">
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
			<a class ="navbar-brand" href="home.jsp">Inicio</a>
		</div>
		<div class="navbar navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href=>Alumnos</a>
				<ul class="dropdown-menu">
					<li><a href="alumnos/listado">Listado de alumnos</a></li>
					<li><a>Crear nuevo alumno</a></li>
				</ul>
				</li>
			</ul>
			<ul class="navbar navbar-collapse navbar-ex1-collapse">
				<li class="dropdown"><a>Cursos</a>
					<ul class="dropdown-menu">
						<li><a href="cursos/listado">Listado de cursos</a></li>
						<li><a>Crear nuevo curso</a></li>
					</ul>
				</li>
			</ul>
			<ul>
				<li class="dropdown"><a>Modulos</a>
					<ul class="dropdown-menu">
						<li><a href="modulos/listado">Listado de modulos</a></li>
						<li><a>Crear nuevo modulo</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>