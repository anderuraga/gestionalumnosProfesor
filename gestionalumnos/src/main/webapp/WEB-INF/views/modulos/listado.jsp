<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@page import="com.ipartek.formacion.dao.persistence.Modulo"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../includes/header.jsp"/><!-- Aqui se compila previamente, tiene codigo java, se tiene que meter en el include.
Esto hace que tarde más en cargar, pero puede ser interesante a la larga -->
<body>
<main>
<h2>LISTADO MODULOS</h2>

<a href="modulos/addModulo"><p>Crear modulo</p></a>
<%

List<Modulo>modulos=(List<Modulo>)request.getAttribute("listado-modulos");
	if(modulos!=null){
		for(Modulo modulo: modulos){
			out.println("<p>"+modulo.getNombre()+"</p>");
		}
	}else{
		%><p>No se han encontrado modulos en la base de datos.</p><%
	}%>


<%@ include file="../includes/footer.jsp" %><!-- Aqui no se compila previamente, no tiene codigo java -->