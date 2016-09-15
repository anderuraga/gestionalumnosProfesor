<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Gestión de Empleados / Departamentos</title>
<!--[if lt IE 9]>
	   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	 <![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<!-- BOOTSTRAP BASE STYLES -->
<link rel="stylesheet" href="css/bootstrap.css" />
<!-- FONT AWESOME -->
<link rel="stylesheet" href="css/font-awesome.css" />
<!-- MY THEME STYLES -->
<link rel="stylesheet" href="css/style.css" />
<!-- JQUERY -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BOOTSTRAP JS LIBS -->
<script src="js/bootstrap.min.js"></script>
</head>
<body class="container-fluid">
	<header class="row">
		<h1 class="col-xs-6">Gestion de Empleados Ipartek</h1>
	</header>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Ipartek</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${constantes.departamentoServlet }">DEPARTAMENTOS</a></li>
					<li><a href="${constantes.empleadoServlet }">EMPLEADOS</a></li>
				</ul>
				<c:if test="${not empty sessionScope[constantes.attUsuario]}">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Desconectar</a></li>
					</ul>
				</c:if>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>