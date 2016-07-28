<%@page import="java.util.Properties"%>
<%@page import="com.ipartek.formacion.controller.listener.InitListener"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="language" value="es_ES" />
<c:set var="language" value="${sessionScope.usuario.idioma.locale}"
	scope="page" />
<!DOCTYPE html>
<html lang="${language} ">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">

<title>Empleados y departamentos</title>

<!-- BOOSTRAP BASE STYLES -->
<link rel="stylesheet" href="css/bootstrap.min.css" />

<!-- FONTAWASONE -->
<link rel="stylesheet" href="css/font-awesome.min.css" />

<!-- MY THEME STYLES -->
<link rel="stylesheet" href="css/styles.css" />

<!-- jQuery 1.13 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!--  BOOTSTRAP JS LIBS -->
<script src="js/bootstrap.min.js"></script>

</head>
<body class="container-fluid">
	<header class="row">
		<h1 class="col-xs-10">Ipartek - Gestion de Empleados</h1>
		<% //GARGAMOS PROPERTIES
			Properties props = (Properties) getServletContext().getAttribute(
					InitListener.PROPS_NAME);
		%>
		//FIN GARGAMOS PROPERTIES <a
			class="btn col-xs-offset-2 col-xs-2 btn-info"
			href="<%=props.getProperty("SERVLETLogout")%>"> <span
			class="fa fa-sign-out" aria-hidden="true"> </span> <fmt:message
				key="header.desconectar" />
		</a>
	</header>

	<nav class="navbar navbar-inverse" role="navigation">
		<!-- El logotipo y el menu-icon se apilan en caso de falta de espacio-->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only"> Desplegar navegación </span> <span
					class="icon-bar"> </span> <span class="icon-bar"> </span> <span
					class="icon-bar"> </span>
			</button>
			<a class="navbar-brand" href="index.jsp">Página Principal</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown"
					href="<%=props.getProperty("SERVLETEmpleados")%>"> Empleados </a>
					<ul class="dropdown-menu">
						<li><a href="<%=props.getProperty("JSPlistadoEmpleados")%>">
								Ver Empleados </a></li>
						<li><a
							href="<%=props.getProperty("SERVLETEmpleados")%>?<%=props.getProperty("parCodigo")%>=<%=props.getProperty("parEmpleado")%>">
								Crear Empleado Nuevo </a></li>


					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown"
					href="<%=props.getProperty("SERVLETDepartamentos")%>">
						Departamentos </a>
					<ul class="dropdown-menu">
						<li><a
							href="<%=props.getProperty("JSPlistadoDepartamentos")%>">
								Todos los Departamentos </a></li>
						<li><a
							href="<%=props.getProperty("SERVLETDepartamentos")%>?<%=props.getProperty("parCodigo")%>=<%=props.getProperty("parDepartamento")%>">
								Crear Departamento Nuevo</a></li>




					</ul></li>


			</ul>
		</div>
	</nav>