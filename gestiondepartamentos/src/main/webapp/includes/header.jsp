
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- MENU IDIOMA -->
<c:set var="language" value="es_ES" />
<c:set var="selectedLanguage" value="${usuario.idioma }" />
<c:choose>
	<c:when test="${!empty selectedLanguage }">
		<c:set var="language" value="${selectedLanguage.locale}" />
	</c:when>
</c:choose>

<c:set var="localeCode" value="${response.locale}" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.formacion.service.i18n.i18nmesages" />
<!DOCTYPE html>
<html lang="${language}">
<!-- FIN MENU IDIOMA -->

<head>

<title>Gestion de departamentos</title>
<!-- CARGA DE ESTILOS -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<!-- BOOTSTRAP BASE STYLES -->
<link rel="stylesheet" href="css/bootstrap.min.css" />
<!-- BOOTSTRAP THEME STYLES -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css" />
<!-- FONT AWESOME -->
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!-- MY THEME STYLES -->
<link rel="stylesheet" href="css/style.css" />
<!-- JQUERY -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BOOTSTRAP JS LIBS -->
<script src="js/bootstrap.min.js"></script>
<!-- FIN CARGA DE ESTILOS -->

</head>





<body class="container-fluid">
	<header class="row">
		<h1>Gestion de departamentos</h1>
	</header>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
				<h3>Hola mundo</h3>
		</div>
		<!-- /.container-fluid -->
	</nav>