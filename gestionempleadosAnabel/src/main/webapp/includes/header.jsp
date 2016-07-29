<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta>
<meta charset="UTF-8">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>Gestion de Empleados</title>
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
		<h1 class="col-xs-12">Gestion de Empleados</h1>
	</header>	
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.jsp">Inicio</a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Desplegar navegación</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="navbar navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toggle" data-toggle="dropdown" href="${properties.ServletDepartamento}">Departamentos</a>
				<ul class="dropdown-menu">
					<li><a href="${properties.ServletDepartamento}">Ver departamentos</a>
					<li><a href="${properties.ServletDepartamento}?${properties.parCodigo}=${Departamento.CODIGO_DEPARTAMENTO}">Crear nuevo departamento</a>
				</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a class="dropdrown-toogle" data-toggle="dropdown" href="${properties.ServletEmpleado}">Empleados</a>
				<ul class="dropdown-menu">
					<li><a href="${properties.ServletEmpleado}">Ver Empleados</a></li>
					<li><a href="${properties.ServletEmpleado}?${properties.parCodigo}=${Departamento.CODIGO_DEPARTAMENTO}">Dar de alta empleado</a>
				</ul>
				</li>
			</ul>
		</div>
	</nav>