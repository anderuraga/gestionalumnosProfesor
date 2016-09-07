<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@page import="com.ipartek.formacion.dao.persistence.Curso"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../includes/header.jsp"/><!-- Aqui se compila previamente, tiene codigo java, se tiene que meter en el include.
Esto hace que tarde más en cargar, pero puede ser interesante a la larga -->
<body>
<main>
<h2>LISTADO CURSOS</h2>

<a href="cursos/addCurso"><p>Crear curso</p></a>
<%
 


List<Curso>cursos=(List<Curso>)request.getAttribute("listado-cursos");
	if(cursos!=null){
		for(Curso curso: cursos){
			out.println("<p>"+curso.getNombre()+"</p>");
		}
	}else{
		%><p>No se han encontrado cursos en la base de datos.</p><%
	}%>


	


<%@ include file="../includes/footer.jsp" %><!-- Aqui no se compila previamente, no tiene codigo java -->