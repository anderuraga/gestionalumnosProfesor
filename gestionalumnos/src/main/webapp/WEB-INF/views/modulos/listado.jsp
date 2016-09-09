<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page import="com.ipartek.formacion.dao.persistence.Modulo"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="../includes/header.jsp"/><!-- Aqui se compila previamente, tiene codigo java, se tiene que meter en el include.
Esto hace que tarde más en cargar, pero puede ser interesante a la larga -->

<h2>LISTADO MODULOS</h2>

<a href="modulos/addModulo"><p>Crear modulo</p></a>

<div class="row">
	<div class="col-xs-12 col-sm-6">
			<table class="table table-bordered">
			     <thead>
			     	<tr>
				     	<th>Nombre</th>
				     	<th>Unidad Formativa</th>
				     	<th>Duración</th>
				     	<th>Acción</th>
			     	</tr>
			     </thead>
			     <tbody>
<%
List<Modulo>modulos=(List<Modulo>)request.getAttribute("listado-modulos");
	if(modulos!=null){
		for(Modulo modulo: modulos){%>		
		       <tr>
			       <td><%=modulo.getNombre() %></td>
			       <td><%=modulo.getuFormativa() %></td>
			       <td><%=modulo.getDuracion() %></td>
			       <td><a href='modulos/<%=modulo.getCodigo() %>'>
			       		<button class="col-xs-10 btn btn-warning">Editar</button>
			       </a>
		            <a href='modulos/deleteModulo/<%=modulo.getCodigo() %>'>
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