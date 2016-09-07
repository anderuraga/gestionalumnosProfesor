<%@page import="com.ipartek.formacion.dao.persistencia.Curso"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../includes/header.jsp"/>

<main>
	
	<!-- En el enlace de crear curso, le paso la acción (addAlumno) al controller -->
	<a href="cursos/addCurso" 
		class="btn btn-info" role="button">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
	</a>
	
	<%
 
	List<Curso>cursos = (List<Curso>)request.getAttribute("listado-cursos");
	if((cursos!=null) && (cursos.size()>0)){
		%>


	<div class="panel panel-primary">
		<div class="panel-heading">LISTADO DE CURSOS</div>
		<div class="panel-body">
			<p>Información de los cursos disponibles en Ipartek</p>
		</div>
		
		<table class="table">
			<tr>
			<th>NOMBRE</th>
			<th>EDITAR</th>
			<th>BORRAR</th>
		</tr>
		<% 
		for(Curso curso: cursos){
			%>
			<tr>
				<td><%=curso.getNombre() %></td>
				<td>
					<a href="cursos/<%=curso.getCodigo() %>" class="btn btn-info" role="button">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					</a>
				</td>
				<td>
					<form action="cursos/<%=curso.getCodigo()%>" method="post">
					<button type="submit" class="btn btn-warning">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
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