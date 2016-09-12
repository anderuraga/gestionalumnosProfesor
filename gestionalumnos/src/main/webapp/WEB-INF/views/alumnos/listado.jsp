<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>

<spring:url value="/resources/css/bootstrap.min.css" var="cssBootstrap" />
<spring:url value="css/font-awesome.min.css" var="cssFont" />
<spring:url value="css/styles.css" var="cssStyle"/>
    
<jsp:include page="../includes/header.jsp"/><!-- Aqui se compila previamente, tiene codigo java, se tiene que meter en el include.
Esto hace que tarde más en cargar, pero puede ser interesante a la larga -->
<body>
<main>
<h2>LISTADO ALUMNOS</h2>

<a href="alumnos/addAlumno"><p>Crear alumno</p></a>

<div class="row">
	<div class="col-xs-12 col-sm-6">
			<table class="table table-bordered">
			     <thead>
			     	<tr>
				     	<th>Nombre</th>
				     	<th>Apellidos</th>
				     	<th>Fecha Nacimiento</th>
				     	<th>Acción</th>
			     	</tr>
			     </thead>
			     <tbody>
<%
List<Alumno>alumnos=(List<Alumno>)request.getAttribute("listado-alumnos");
	if(alumnos!=null){
		for(Alumno alumno: alumnos){%>		
		       <tr>
			       <td><%=alumno.getNombre() %></td>
			       <td><%=alumno.getApellidos() %></td>
			       <td><%=alumno.getfNacimiento() %></td>
			       <td><a href='alumnos/<%=alumno.getCodigo() %>'>
			       		<button class="col-xs-10 btn btn-warning">Editar</button>
			       </a>
		            <a href='alumnos/deletealumno/<%=alumno.getCodigo() %>'>
		            	<button class="col-xs-10 btn btn-danger">Borrar</button>
		            </a>
		            </td>
		       </tr>
		    <%
		}
	}else{
		%><p>No se han encontrado modulos en la base de datos.</p><%
	}%>

				     
				</tbody>
		</table>
	</div>
</div>	
	


<%@ include file="../includes/footer.jsp" %><!-- Aqui no se compila previamente, no tiene codigo java -->