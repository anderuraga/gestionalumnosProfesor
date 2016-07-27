<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es_ES">
	<head>
		<meta charset="UTF-8">
		<title>Ipartek - Gestion de Empleados</title>
		
		<!-- BOOTSTRAP BASE STYLES -->		
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		
		<!--  BOOTSTRAP JS LIBS -->
	 	<script src="js/bootstrap.min.js"></script>
		
		<!-- FONTAWESOME -->	
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		
		<!-- OWN STYLES -->	
		<link rel="stylesheet" href="css/style.css" />
		
		<!-- JQUERY LIBRARY 1.11.3  -->
	 	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
	 	<script src="js/jquery.min.js"></script>

		<!--[if lt IE 9]>
		   	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
		
		
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
	
	<body class="container-fluid">
		<header class="row"><h1 class="col-xs-12">Ipartek - Gestion de Empleados</h1></header>
			
			<!-- <nav class="navbar navbar-inverse" role="navigation"> -->
			<nav class="navbar navbar-default" role="navigation">
				<!-- El logotipo y el icono que despliega el menú se agrupan
				para mostrarlos mejor en los dispositivos móviles -->
				
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
					        data-target=".navbar-ex1-collapse">
						<span class="sr-only">Desplegar navegación</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="">Inicio</a>
				</div>
			
				<div class="collapse navbar-collapse navbar-ex1-collapse">
			   		<ul class="nav navbar-nav">						
						<li>
							<a href="empleado.do">Empleados</a>
						</li>
						
						<li>
							<a href="departamento.do">Departamentos</a>
						</li>
					</ul>
				</div>
			</nav>