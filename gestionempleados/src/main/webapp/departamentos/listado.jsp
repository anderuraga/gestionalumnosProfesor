<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Departamento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"/> 
<main>
<!-- 
warning -> Naranja
danger  -> Rojo
info    -> Azul claro
succes  -> verde
default -> blanco
primary -> Azul oscuro
 -->
		<a class="btn btn-warning" href="index.jsp">Atrás</a>
		<a class="btn btn-success" href="${properties.servletDepartamento} ? ${ properties.parCodigo} = ${ Departamento.CODIGO_DEPARTAMENTO}">
			<span class="fa fa-plus fblack" aria-hidden="true"></span>
			Departamento
		</a> 

		<%		
			List<Departamento> departamentos = (List<Departamento>) request.getAttribute("listado_departamentos");
			if(departamentos!=null){
				int i=1;
				
				for(Departamento departamento: departamentos){
					%>
					<form class='col-xs-2 col-md-6' action="${properties.servletDepartamento}" 
					method="post">
	<!--  la variable operacion-->				
					<input type="hidden" name="${properties.parOperacion}" value="${properties.opDelete }"/>
	<!--  				//la variable del codigo del departamento-->	
					<input type="hidden"  name="${properties.parCodigo}" value="${departamento.codigo }"/>
	<!-- 				//el boton de borrar-->
					<button type="submit" class="btn btn-danger">Borrar</button>
					</form>
					
					<div class="row">
						<a class="col-xs-10 col-md-6" href="${properties.servlet_departamentos }
							?${properties.parCodigo }
							= ${departamento.codigo } ">
							${departamento.nombre }
						</a>
										
					</div>
					<%
					i++;
				}
			}
	%>
</main>
<%@ include file="../includes/footer.jsp" %>