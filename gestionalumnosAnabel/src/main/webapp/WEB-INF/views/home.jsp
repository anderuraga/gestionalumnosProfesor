<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<jsp:include page="includes/header.jsp"/>

<c:set var="lista" value="${listado_alumnos}" />

<h1>
	Bienvenido a la aplicación de gestión de alumnos de Ipartek.
</h1>

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
</c:if>


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
%> 

<jsp:include page="includes/footer.jsp"/>