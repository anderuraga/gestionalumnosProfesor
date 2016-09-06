<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../includes/header.jsp" />
<c:set var="lista" value="${listado_alumnos}" />
<main> 
<!-- 
<%
	List<Alumno> alumnos = (List<Alumno>)request.getAttribute("listado-alumnos");
	if(alumnos.size()>0){
	  for(Alumno a : alumnos){
	    out.print("<p>"+a.getNombre()+" "+a.getApellidos()+"</p>");
	    
	  } 
	}else{
	  %>
	  <p>No se han encontrado alumnos en la BB.DD.</p>
	  <%
	}
%>  -->
<!-- 
<c:if test="${!empty lista}">
	<table class="table">
		<thead>
			<tr>Nombre</tr>
			<tr>Apellidos</tr>
		</thead>
		<tbody>
			<c:forEach items="${lista}" var="alumno">
				<tr>${alumno.nombre}</tr>
				<tr>${alumno.apellidos}</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>  -->
</main>
<jsp:include page="../includes/footer.jsp" />