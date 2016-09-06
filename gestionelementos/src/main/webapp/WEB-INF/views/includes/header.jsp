<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>

<title>Gestion de Cursos</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<!-- BOOTSTRAP BASE STYLES -->
<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
<!-- BOOTSTRAP THEME STYLES -->
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css" />
<!-- FONT AWESOME -->
<link rel="stylesheet" href="resources/css/font-awesome.min.css" />
<!-- MY THEME STYLES -->
<link rel="stylesheet" href="resources/css/style.css" />
<!-- JQUERY -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BOOTSTRAP JS LIBS -->
<script src="resources/js/bootstrap.min.js"></script>
<!--[if lt IE 9]>
	   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	 <![endif]-->
</head>

<body>
	<!-- Titulo de la pagina -->
	<header class="row">
		<h1 class="col-xs-12" align="center">Bienvenido a la
			aplicaci&oacute;n de gestion de elementos</h1>
	</header>
<jsp:include page="navbar.jsp" />