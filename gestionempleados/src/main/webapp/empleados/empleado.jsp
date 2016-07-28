<%@page import="com.ipartek.formacion.service.Idioma"%>
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
		
		Empleado empleado = (Empleado) request.getAttribute("${properties.attEmpleado}");
		
		int op = -1;
		String tGuardar = "";
		if(empleado!=null){
			tGuardar = "guardar";
			op = 2;//props.getProperty("opUpdate");
		}else{
			op = 0;//props.getProperty("opCreate");
			tGuardar ="crear nuevo";
			empleado = new Empleado();
		}
	%>
		<a href="${properties.servletEmpleado}">Atras</a>


		
		<%
		if(empleado!=null){
			%>
				<form name="" id="" method='post' class="form-horizontal"
					action="${properties.servletEmpleado}">
					<input type="hidden" 
						id="${properties.parOperacion}"
						name="${properties.parOperacion}" 
						value="<%=op %>"/>
					<input type="hidden" 
						id="${properties.parCodigo}"
						name="${properties.parCodigo}"
						value="<%=empleado.getCodigo()%>"/>
					<div class="form-group">
						<label class="col-xs-2" for="${properties.parNombre}">Nombre:</label>
						<div class="col-xs-10">
						<input type="text" class="form-control"
							name="${properties.parNombre}" 
							id="${properties.parNombre}" 
							value="<%=empleado.getNombre() %>"
							/>
						</div>
						<span class="alert alert-danger hide"></span>
					</div>
					<div class="form-group">
						<label class="col-xs-2" for="${properties.parApellidos}">Apellidos:</label>
						<div class="col-xs-10">					
						<input type="text"  class="form-control"
							name="${properties.parApellidos}"  
							id="${properties.parApellidos}"  
							value="<%=empleado.getApellidos() %>"
							/>
							</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2" for="${properties.parDni}">Dni:</label>
						<div class="col-xs-10">
						<input type="text" pattern="((([A-Z]|[a-z])\d{8})|(\d{8}([A-Z]|[a-z])))"
							name="${properties.parDni}"   class="form-control"
							id="${properties.parDni}" 
							value="<%=empleado.getDNI() %>"
							/>
							</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2">Fecha:</label>
						<div class="col-xs-10">
					<%
					GregorianCalendar calendar = new GregorianCalendar();
					calendar.setTime(empleado.getfNacimiento());
												
					%>
							<div class="row">
								<div class="col-xs-3">
									<label for="">Día:</label>
									<input type="number"  value="<%=calendar.get(GregorianCalendar.DAY_OF_MONTH) %>" class="form-control" min="1" max="31" step="1" name="${properties.parDia}"	/>
								</div>
								<div class="col-xs-3">
										<label for="">Mes:</label>
										<input type="number" value="<%=calendar.get(GregorianCalendar.MONTH)+1 %>" class="form-control" min="1" max="12" step="1" name="${properties.parMes}"	/>
									
								</div>
								<div class="col-xs-6">
									<label for="">Año:</label>
									<input type="number"  value="<%=calendar.get(GregorianCalendar.YEAR) %>" class="form-control" min="" max="" name="${properties.parYear}"	/>
								</div>
							</div>
						</div> 
					</div>
					<div class="form-group">
						<label class="col-xs-2">Idiomas:</label>
						<div class="col-xs-10">
					
							<input type="checkbox" name="${properties.parIdiomas}" id=""
								<%= empleado.getIdiomas().contains(Idioma.CASTELLANO) ? "checked" : "" %> 
								 value="<%=Idioma.CASTELLANO.getCodigo() %>"/> 
								<%=Idioma.CASTELLANO.getNombre() %>
							<input type="checkbox" name="${properties.parIdiomas}" id="" 
								<%= empleado.getIdiomas().contains(Idioma.EUSKERA) ? "checked" : "" %>
								value="<%=Idioma.EUSKERA.getCodigo() %>"/> 
								<%=Idioma.EUSKERA.getNombre() %>
							<input type="checkbox" name="${properties.parIdiomas}" id="" 
								<%= empleado.getIdiomas().contains(Idioma.INGLES)  ? "checked" : "" %>
								value="<%=Idioma.INGLES.getCodigo() %>"/> 
								<%=Idioma.INGLES.getNombre() %>															
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