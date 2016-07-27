<%@page import="com.ipartek.formacion.pojo.Departamento"%>
<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@page import="com.ipartek.formacion.service.I18n.I18n"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:set var="language" value="en_EN"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>Gestion de Empleados </title>
	<!-- BOOSTRAP BASE STYLES -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<!-- FONTAWASONE -->
	<link rel="stylesheet" href="css/font-awesome.min.css"/>
	<!-- MY THEME STYLES -->
	<link rel="stylesheet" href="css/styles.css"/>
	<!-- jQuery 1.13 -->
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	 <!--  BOOTSTRAP JS LIBS -->
	 <script src="js/bootstrap.min.js"></script>
	 <!--[if lt IE 9]>
	   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	 <![endif]-->
</head>
<body class="container-fluid">
	<header class="row"><h1 class="col-xs-12">Ipartek - Gestion de empleados</h1></header>
	<%
	if (session!=null){
		%>
		<div name="logout" id="logout" class="col-xs-12 col-md-2">
        	<a href="${properties.servletLogout}" class="btn btn-lg btn-primary btn-block btn-logout">Logout</a>
        </div>
                
		<%
	}
	%>
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
		    Pagina principal
		  </div>
		  <div class="collapse navbar-collapse navbar-ex1-collapse">
    		<ul class="nav navbar-nav">
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="${properties.servletEmpleado}">
						Empleado
					</a>
					<ul class="dropdown-menu">
						<li><a href="${properties.servletEmpleado}?${properties.parCodigo}=<%=Empleado.CODIGO_EMPLEADO%>">Crear empleado Nuevo</a></li>
						<li><a href="${properties.servletEmpleado}">Listar Empleados</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="${properties.servletDepartamento}">
						Departamento
					</a>
					<ul class="dropdown-menu">
						<li><a href="${properties.servletDepartamento}?${properties.parCodigo}=<%=Departamento.CODIGO_DEPARTAMENTO%>">Crear Departamento Nuevo</a></li>
						<li><a href="${properties.servletDepartamento}">Listar Departamentos</a></li>
					</ul>
				</li>
			</ul>
			</div>
		</nav>
		