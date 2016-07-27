<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@page import="com.ipartek.formacion.service.EmpleadoServiceImp"%>
<%@page import="com.ipartek.formacion.service.EmpleadoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<jsp:include page="../includes/header.jsp" />

<!--  BOOTSTRAP JS LIBS -->
<script src="js/bootstrap.min.js"></script>
		
<!-- JQUERY LIBRARY 1.11.3  -->
<script src="js/jquery.min.js"></script>	
	
<main>

	<a href="index.jsp" class="btn btn-warning">
		<span class="fa fa-arrow-left" aria-hidden="true"></span>
		Atras
	</a>
	<a href="" class="btn btn-success">
		<span class="fa fa-plus fblack" aria-hidden="true"></span>
		Empleado
	</a>
	<br/>
	
	<%
		EmpleadoService eService = new EmpleadoServiceImp().getInstance();
		List<Empleado> empleados = (List<Empleado>) eService.getAll();
		
		if(empleados!=null){
			String formulario = "";
			
			for(Empleado empleado: empleados){
				
				formulario = "<form class='col-xs-2' action='' method='post'>";
				// boton de borrar
				formulario += "<button type='submit' class='btn btn-danger'><span class='fa fa-trash-o' aria-hidden='true'> </span> Borrar</button>";
				formulario += "</form>";
				
				%>
				<div class="row">
					<a class="col-xs-4 col-md-4" href=''>
							<%= empleado.getCodigo() + "- " + empleado.getNombre() + " " + empleado.getApellidos() + " - " + empleado.getDni() %>
					</a>
					
					<%= formulario %>
				</div>
				
				<%
			}
		}
		
	%>

</main>

<%@ include file="/includes/footer.jsp" %>