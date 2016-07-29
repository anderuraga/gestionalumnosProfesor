<%@page import="com.ipartek.formacion.service.Idioma"%>
<%@page import="java.util.Properties"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
<jsp:include page="includes/header.jsp"/><!-- Aqui se compila previamente, tiene codigo java, se tiene que meter en el include.
Esto hace que tarde más en cargar, pero puede ser interesante a la larga -->
<main>
 	<jsp:include page="includes/error.jsp"/>
 	<!--
    you can substitute the span of reauth email for a input with the email and
    include the remember me checkbox
    -->
    <main class="container-fluid">

<%

if (session!=null && "${properties.attEmpleado}"!=null){
%>
		<div name="logout" id="logout" class="col-xs-12 col-md-5">
        	<a href="${properties.servletLogout}" class="btn btn-lg btn-primary btn-block btn-logout">Logout</a>
        </div>
                
		<%
	}else{
%>
    <jsp:include page="includes/login.jsp"/>
 <%} %>
</main>
<%@ include file="includes/footer.jsp" %><!-- Aqui no se compila previamente, no tiene codigo java -->