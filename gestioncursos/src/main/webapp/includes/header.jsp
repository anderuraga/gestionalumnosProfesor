<%@page import="com.ipartek.formacion.service.i18n.I18n"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.ipartek.formacion.pojo.Usuario"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="com.ipartek.formacion.pojo.Alumno"%>
<%@page import="com.ipartek.formacion.pojo.Modulo"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var="language" value="en_EN"/>
<c:set var="language" value="<%=I18n.getBrowserLocale(response.getLocale()) %>"/>
<c:set var="language" value="${sessionScope.usuario.idioma.locale}" scope="page"/> <!-- scope equivale a request.setattribute (mejor no usarlo) -->
<c:set var="localeCode" value="${response.locale}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="com.ipartek.formacion.service.i18n.i18nmessages"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8">
	<title>Gestion de Cursos </title>
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
	<header class="row">
		<h1 class="col-xs-8"><fmt:message key="header.cabecera"/></h1>
		<%
		Usuario user=(Usuario)session.getAttribute(Constantes.ATT_USUARIO);
		if(user!=null){
			%>	
			<a class="btn col-xs-offset-2 col-xs-2 btn-info" href="#">
			<span class="fa fa-sign-out" aria-hidden="true"></span>
			<fmt:message key="header.desconectar"/>
		</a>
		<% 
		}
		%>	
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
		    <a class="navbar-brand" href="index.jsp"><fmt:message key="header.pagprincipal"/></a>
		  </div>
		  <div class="collapse navbar-collapse navbar-ex1-collapse">
    		<ul class="nav navbar-nav">
    			<li class="dropdown">
					<a class="dropdown-toggle" href="<%=Constantes.SERVLET_CURSOS%>">
						<fmt:message key="header.cursos"/>
					</a>
					<ul  class="dropdown-menu">
						<li>
							<a href="<%=Constantes.SERVLET_CURSOS%>">
							<fmt:message key="header.vercursos"/>
							</a>						
						</li>
						<li>
							<a  href="<%=Constantes.SERVLET_CURSOS%>?<%=Constantes.PAR_CODIGO%>=<%=Curso.CODIGO_CURSO%>">
							<fmt:message key="header.cursonuevo"/>
							</a>						
						</li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="<%=Constantes.SERVLET_ALUMNOS%>">
						<fmt:message key="header.alumnos"/>
					</a>
					<ul  class="dropdown-menu">
						<li>
							<a href="<%=Constantes.SERVLET_ALUMNOS%>">
								<fmt:message key="header.veralumnos"/>
							</a>
						</li>
						<li>
							<a href="<%=Constantes.SERVLET_ALUMNOS%>?<%=Constantes.PAR_CODIGO%>=<%=Alumno.CODIGO_ALUMNO%>">
								<fmt:message key="header.alumnonuevo"/>
							</a></li>
						</li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="<%=Constantes.SERVLET_MODULOS%>">
						<fmt:message key="header.modulos"/>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="<%=Constantes.SERVLET_MODULOS%>">
								<fmt:message key="header.vermodulos"/>
							</a>
						</li>
						<li><a href="<%=Constantes.SERVLET_MODULOS%>?<%=Constantes.PAR_CODIGO%>=<%=Modulo.CODIGO_MODULO%>">
								<fmt:message key="header.modulonuevo"/>
							</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="<%=Constantes.SERVLET_MODULOS%>">
						<fmt:message key="header.admin"/>
					</a>
					<ul class="dropdown-menu">
						<li>
							<a href="<%=Constantes.SERVLET_ADMINISTRACION%>">
								<fmt:message key="header.verconectados"/>
							</a>
						</li>
						
					</ul>
				</li>
			</ul>
			</div>
		</nav>