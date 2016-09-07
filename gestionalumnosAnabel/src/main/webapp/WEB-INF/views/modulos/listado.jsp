<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.ipartek.formacion.dao.persistencia.Modulo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../includes/header.jsp" />
<main>
<div class="row">
	<div class="col-xs-6">
		<a class="btn btn-success" href="/addModulos">Crear Modulo</a>
	</div>
</div>
<div>
<br>
<br>
</div>
<%
	List<Modulo> modulos = (List<Modulo>) request.getAttribute("listado-modulos");
	if(modulos.size() > 0){
		for(Modulo mod: modulos){
			out.print("<p>"+mod.getNombre()+"</p>");
		}
	}else{
		%> 
		<p>No se ha encontrado ningun modulo en la BB.DD.</p>
		<%
	}
%>

</main>

<jsp:include page="../includes/footer.jsp" />