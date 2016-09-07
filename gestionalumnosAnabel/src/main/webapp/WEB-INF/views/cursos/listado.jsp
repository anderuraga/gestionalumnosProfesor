<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.ipartek.formacion.dao.persistencia.Curso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../includes/header.jsp" />
<main>

<%
	List<Curso> cursos = (List<Curso>) request.getAttribute("listado-cursos");
	if(cursos.size() > 0){
		for(Curso cur: cursos){
			out.print("<p>"+cur.getNombre());
		}
		
	}else{
		%>
		<p>No se han encontrado cursos en la BB.DD.</p>
		<%
	}
%>

</main>
<jsp:include page="../includes/footer.jsp" />