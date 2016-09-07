<%@page import="com.ipartek.formacion.dao.persistencia.Modulo"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../includes/header.jsp"/>

<main>
	
		<!-- En el enlace de crear alumno, le paso la acción (addAlumno) al controller -->
	<a href="modulos/addModulo" 
		class="btn btn-info" role="button">
		<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
	</a>
	
	<%
 
	List<Modulo>modulos = (List<Modulo>)request.getAttribute("listado-modulos");
	if((modulos!=null) && (modulos.size()>0)){
		%>


	<div class="panel panel-primary">
		<div class="panel-heading">LISTADO DE MODULOS</div>
		<div class="panel-body">
			<p>Información de los modulos disponibles en Ipartek</p>
		</div>
		
		<table class="table">
			<tr>
			<th>NOMBRE</th>
			<th>EDITAR</th>
			<th>BORRAR</th>
		</tr>
		<% 
		for(Modulo modulo: modulos){
			%>
			<tr>
				<td><%=modulo.getNombre() %></td>
				<td>
					<a href="modulos/<%=modulo.getCodigo() %>" class="btn btn-info" role="button">
					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
					</a>
				</td>
				<td>
					<form action="modulos/<%=modulo.getCodigo()%>" method="post">
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