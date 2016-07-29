<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GESTION DE EMPLEADOS</title>
<!-- BOOTSTRAP BASE STYLES-->
	<link rel="stylesheet" href="css/bootstrap.min.css" />
	<!-- FONT-AWESOME -->
	<link rel="stylesheet" href="css/font-awesome.min.css" />
	<!-- MY THEME STYLES -->
	<link rel="stylesheet" href="css/styles.css" />
	<!--JQUERY 1.13-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	 <!--[if lt IE 9]>
	   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	 <![endif]-->
</head>
<body class="container-fluid">
	<header class="row"> 
		<h1 class="col-xs-12">IPARTEK - GESTION DE EMPLEADOS</h1>
	</header>
	
	<nav class="navbar navbar-inverse" role="navigation">
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
			    <li class="dropdown">
        			<a href="empleado.do" class="dropdown-toggle" data-toggle="dropdown">EMPLEADOS<b class="caret"></b></a>
        			<ul class="dropdown-menu">
        				<li >
        					<a href="${constantes.empleadoServlet}" >ver empleados</a>
        				</li>
        			</ul>
        		</li>
        		<li class="dropdown">
        			<a href="departamento.do" class="dropdown-toggle" data-toggle="dropdown">DEPARTAMENTOS<b class="caret"></b>
        			</a>
        			<ul class="dropdown-menu">
        				<li >
        					<a href="${constantes.departamentoServlet}">ver departamentos</a>
        				</li>
        			</ul>
        		</li>
        		
        	</ul>
        	<ul class="navrbar navbar-right">
        	<li>
        		<c:if test="${!empty sessionScope[constantes.attUsuario]}"> 
        			<p id="welcome"> Bienvenido/a ${sessionScope[constantes.attUsuario].userName}
					<a href="${constantes.logoutServlet}" class="btn btn-danger" id="btnSalir">SALIR</a>
					</p>
				</c:if>
        		</li>
        	</ul>
		</div>
	</nav>
</body>
