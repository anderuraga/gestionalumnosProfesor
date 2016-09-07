<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../includes/header.jsp" />
<main> 
<div class="row">
	<div class = "col-xs-4">
		<a class="btn btn-success" href="/addAlumnos">Crear Alumno</a>
	</div>
</div>
<div>
<br>
<br>
</div>
<%
	List<Alumno> alumnos = (List<Alumno>)request.getAttribute("listado-alumnos");
	if(alumnos.size()>0){
	  for(Alumno a : alumnos){
	   %>
	   <a href="addAlumno"><%out.print("<p>"+a.getNombre()+" "+a.getApellidos()+"</p>");%></a>
		 
	    <%
	  } 
	}else{
	  %>
	  <p>No se han encontrado alumnos en la BB.DD.</p>
	  <%
	}
%>  
</main>
<jsp:include page="../includes/footer.jsp" />