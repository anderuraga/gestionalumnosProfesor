<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>Gestion de Cursos </title>
	<!-- BOOSTRAP BASE STYLES -->
	
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"/>
	<!-- FONTAWASONE -->
	
	<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet"/>
	<!-- MY THEME STYLES -->
	
	<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet"/>
	
	<!-- jQuery 1.13 -->
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	 <!--  BOOTSTRAP JS LIBS -->
	 <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	 
	 <!--[if lt IE 9]>
	   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	 <![endif]-->
	</head>
	<body class="container-fluid">
	<%

	
	%>
	<header class="row">
	<h1 class="col-xs-12">Ipartek - Gestion de Cursos</h1>
	</header>
	<nav class="navbar navbar-inverse" role="navigation">
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
		    <a class="navbar-brand" href="home">Página Principal</a>
		  </div>
		  <div class="collapse navbar-collapse navbar-ex1-collapse">
    		<ul class="nav navbar-nav">
    			<li class="dropdown">
					<a class="dropdown-toggle" href="cursos">
						Ver todos los cursos
					</a>
				</li>
				<li class="dropdown">
					<a  class="dropdown-toggle"  href="alumnos">
						Ver todos los alumnos
					</a>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle"  href="modulos">
						Ver todos los modulos
					</a>
					
				</li>
			
				
				
			</ul>
			</div>
		</nav>