<%@page import="com.ipartek.formacion.service.Idioma"%>
<%@page import="com.ipartek.formacion.pojo.Departamento"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.List"%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<main>
	<%
		
		Departamento departamento = (Departamento) request.getAttribute("${properties.attDepartamento}");
		
		int op = -1;
		String tGuardar = "";
		if(departamento!=null){
			tGuardar = "guardar";
			op = 2;//props.getProperty("opUpdate");
		}else{
			op = 0;//props.getProperty("opCreate");
			tGuardar ="crear nuevo";
			departamento = new Departamento();
		}
	%>
		<a href="${properties.servletDepartamento}" class="btn btn-lg btn-primary">Atras</a>


		
		<%
		if(departamento!=null){
			%>
				<form name="" id="" method='post' class="form-horizontal"
					action="${properties.servletDepartamento}">
					<input type="hidden" 
						id="${properties.parOperacion}"
						name="${properties.parOperacion}" 
						value="<%=op %>"/>
					<input type="hidden" 
						id="${properties.parCodigo}"
						name="${properties.parCodigo}"
						value="<%=departamento.getCodigo()%>"/>
					<div class="form-group">
						<label class="col-xs-2" for="${properties.parNombre}">Nombre:</label>
						<div class="col-xs-10">
						<input type="text" class="form-control"
							name="${properties.parNombre}" 
							id="${properties.parNombre}" 
							value="<%=departamento.getNombre() %>"
							/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2" for="${properties.parDescripcion}">Descripcion:</label>
						<div class="col-xs-10">					
						<input type="text"  class="form-control"
							name="${properties.parDescripcion}"  
							id="${properties.parDescripcion}"  
							value="<%=departamento.getDescripcion() %>"
							/>
						</div>
					</div>	
					<div class="form-group">
						<div class="col-xs-10">
							<button type="submit" class="btn btn-success col-xs-6">
								<%=tGuardar %>
							</button>
						</div>
					</div>
				</form>

			
	<%	}
		%>
</main>
<%@include file="../includes/footer.jsp" %>