<%@page import="com.ipartek.formacion.dao.persistencia.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../includes/header.jsp"/>

<main>

	<!-- En el enlace de crear alumno, le paso la acción (addAlumno) al controller -->
	<a href="alumnos/addAlumno" 
		class="btn btn-info" role="button">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
	</a>
	
	<%
 
	List<Alumno>alumnos = (List<Alumno>)request.getAttribute("listado-alumnos");
	if((alumnos!=null) && (alumnos.size()>0)){
		%>


	<div class="panel panel-primary">
		<div class="panel-heading">LISTADO DE ALUMNOS</div>
		<div class="panel-body">
			<p>Información de los alumnos matriculados en Ipartek</p>
		</div>
		
		<table class="table">
			<tr>
			<th>NOMBRE</th>
			<th>APELLIDO</th>
			<th>EDITAR</th>
			<th>BORRAR</th>
		</tr>
		<% 
		for(Alumno alumno: alumnos){
			%>
			<tr>
				<td><%=alumno.getNombre() %></td>
				<td><%=alumno.getApellidos() %></td>
				<td>
					<a href="alumnos/<%=alumno.getCodigo() %>" class="btn btn-success" role="button">
					<span class="glyphicon glyphicon-pencil"></span>
					</a>
				</td>
				<td>
					<form action="alumnos/<%=alumno.getCodigo()%>" method="post">
					<button type="submit" class="btn btn-danger">
						<span class="glyphicon glyphicon-remove"></span>
					</button>
					</form>
				</td>
			</tr>
				
		<%
		}
	}
		%>	
	
		</table>
	</div>



</main>