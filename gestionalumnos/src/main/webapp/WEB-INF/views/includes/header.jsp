<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<spring:url value="/resources/css/bootstrap.min.css" var="cssBootstrap" />
<spring:url value="/resources/css/font-awesome.min.css" var="cssFont" />
<spring:url value="/resources/css/styles.css" var="cssStyle"/>
<spring:url value="/resources/js/jquery.js" var="jquery"/>
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapjs"/>


<%@ page session="false" %>
<!DOCTYPE html>
<html>


<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>Gestion de Cursos </title>

<!-- CARGAMOS LOS BASICOS DE BOOTSTRAP -->
<link rel="stylesheet" href="${cssBootstrap}" />
<!-- CARGAMOS LAS FUENTES -->
<link rel="stylesheet" href="${cssFont}">
<!-- CARGAMOS NUESTROS ESTILOS -->
<link rel="stylesheet" href="${cssStyle}">


<body class="container-fluid">
	<header class="row"><h1 class="col-xs-12">Ipartek - Gestion de Cursos</h1></header>
    
<nav class="navbar navbar-inverse" >
	<div class="collapse navbar-collapse navbar-ex1-collapse">
    	<ul class="nav navbar-nav">
			<li>
            	<a href="<c:url value='/cursos'/>">Cursos</a>
            </li>
			<li>
                <a href="<c:url value='/alumnos'/>">Alumnos</a>
            </li>
			<li>
                <a href="<c:url value='/modulos'/>">Modulos</a>
            </li>
		</ul>
	</div>
</nav>