<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.ipartek.formacion.controller.listener.InitListener"%>
<%@page import="java.util.Properties"%>
<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<jsp:include page="../includes/header.jsp" />  


<!--  BOOTSTRAP JS LIBS -->
<script src="js/bootstrap.min.js"></script>
		
<!-- JQUERY LIBRARY 1.11.3  -->
<script src="js/jquery.min.js"></script>

<%
	Properties props = null;
	props = (Properties) getServletContext().getAttribute(InitListener.PROPS_NAME);

	Empleado empleado = (Empleado) request.getAttribute(props.getProperty("attEmpleado"));
	int op = -1;
	String tGuardar ="";

	if(empleado!=null){
		op = Integer.parseInt(props.getProperty("opUpdate"));
		tGuardar = "Actualizar";
	} else{
		try{
			op = Integer.parseInt(props.getProperty("opCreate"));
			empleado = new Empleado();
			tGuardar = "Crear";
		} catch(NumberFormatException e){
			System.out.println("Error: "+e.getMessage());
		}
	}
%>
<main>
	<a href="<%= props.getProperty("servletEmpleado") %>" class="btn btn-warning">
		<span class="fa fa-arrow-left" aria-hidden="true"></span>
		Atras
	</a>
	<br/>
	
	<%
	
	if(empleado!=null){
		//out.write(curso.getCodigo() + " - " + curso.getNombre());
		
	%>
		<form class="form-horizontal col-xs-5" method="post" action="<%= props.getProperty("servletEmpleado") %>">
			<input type="hidden"
				name="<%= props.getProperty("parOperacion") %>"
				id="<%= props.getProperty("parOperacion") %>"
				value="<%= op %>" />
				
			<input type="hidden"
				name="<%= props.getProperty("parCodigo") %>"
				id="<%= props.getProperty("parCodigo") %>"
				value="<%= empleado.getCodigo() %>" />
				
			<div class="form-group">
				<label for="<%= props.getProperty("parNombre") %>">Nombre: </label>
				
				<input type="text" 
					name="<%= props.getProperty("parNombre") %>" 
					id="<%= props.getProperty("parNombre") %>"
					value="<%= empleado.getNombre() %>"
					size="20"
					class="form-control"
					placeholder="Nombre del empleado"
					 />
				
				<div class="alert alert-danger alert-dismissible fade in hide" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button> 
					<strong>Holy guacamole!</strong> 
					Best check yo self, you're not looking too good. 
				</div>
					
			</div>
			
			<div class="form-group">
				<label for="<%= props.getProperty("parApellidos") %>">APELLIDOS: </label>
					
				<input type="text" 
					name="<%= props.getProperty("parApellidos") %>" 
					id="<%= props.getProperty("parApellidos") %>"
					value="<%= empleado.getApellidos() %>"
					size="20"
					class="form-control"
					placeholder="Apellidos del empleado"
					 />
			</div>		
				
			<div class="form-group">
				<label for="<%= props.getProperty("parDni") %>">DNI: </label>
				
				<input type="text" pattern="((([A-Z]|[a-z])\d{8})|(\d{8}([A-Z]|[a-z])))"
					name="<%= props.getProperty("parDni") %>" 
					id="<%= props.getProperty("parDni") %>"
					value="<%= empleado.getDni() %>"
					size="20"
					class="form-control"
					placeholder="DNI del empleado"
					 />
			</div>
			
			<div class="form-group">
				<label for="<%= props.getProperty("parNumeroSs") %>">Numero Seguridad Social: </label>
					
				<input type="text" 
					name="<%= props.getProperty("parNumeroSs") %>" 
					id="<%= props.getProperty("parNumeroSs") %>"
					value="<%= empleado.getNumeroSS() %>"
					size="20"
					class="form-control"
					placeholder="Seguridad Social del Empleado"
					 />
			</div>	
			
			<div class="form-group">
				<label for="<%= props.getProperty("parCuentaCorriente") %>">Cuenta Corriente: </label>
					
				<input type="text" 
					name="<%= props.getProperty("parCuentaCorriente") %>" 
					id="<%= props.getProperty("parCuentaCorriente") %>"
					value="<%= empleado.getCuentaCorriente() %>"
					size="20"
					class="form-control"
					placeholder="Telefono del alumno"
					 />
			</div>
			
			<div class="form-group form-inline">
				<label for="<%= props.getProperty("parFechaNacimiento") %>">Fecha Nacimiento: </label>
				
				<%
					GregorianCalendar calendar = new GregorianCalendar();
					calendar.setTime(empleado.getFechaNacimiento());
					
				%>
				
				<input type="number"
					value="<%= calendar.get(GregorianCalendar.DAY_OF_MONTH) %>"
					min="1"
					max="31"
					name="<%= props.getProperty("parDiaNacimiento") %>"
					class="form-control"
					placeholder="Dia"
					 />
					 
				<input type="number"
					value="<%= calendar.get(GregorianCalendar.MONTH)+1 %>"
					min="1"
					max="12"
					name="<%= props.getProperty("parMesNacimiento") %>"
					class="form-control"
					placeholder="Mes"
					 />
				
				<input type="text" 
					value="<%= calendar.get(GregorianCalendar.YEAR) %>"
					name="<%= props.getProperty("parAnnoNacimiento") %>"
					size="12"
					class="form-control"
					placeholder="A&ntilde;o"
					 />
			</div>
			
			<div class="form-group form-inline">
				<label for="<%= props.getProperty("parFechaContratacion") %>">Fecha Contratacions: </label>
				
				<%
					GregorianCalendar calendar2 = new GregorianCalendar();
					calendar2.setTime(empleado.getFechaNacimiento());
					
				%>
				
				<input type="number"
					value="<%= calendar2.get(GregorianCalendar.DAY_OF_MONTH) %>"
					min="1"
					max="31"
					name="<%= props.getProperty("parDiaContratacion") %>"
					class="form-control"
					placeholder="Dia"
					 />
					 
				<input type="number"
					value="<%= calendar2.get(GregorianCalendar.MONTH)+1 %>"
					min="1"
					max="12"
					name="<%= props.getProperty("parMesContratacion") %>"
					class="form-control"
					placeholder="Mes"
					 />
				
				<input type="text" 
					value="<%= calendar2.get(GregorianCalendar.YEAR) %>"
					name="<%= props.getProperty("parAnnoContratacion") %>"
					size="12"
					class="form-control"
					placeholder="A&ntilde;o"
					 />
			</div>
			
			<div class="form-group">
				<label for="<%= props.getProperty("parDireccion") %>">Direccion: </label>
					
				<input type="text" 
					name="<%= props.getProperty("parDireccion") %>" 
					id="<%= props.getProperty("parDireccion") %>"
					value="<%= empleado.getDireccion() %>"
					size="20"
					class="form-control"
					placeholder="Telefono del alumno"
					 />
			</div>
			
			<div class="form-group">
				<label for="<%= props.getProperty("parLocalidad") %>">Localidad: </label>
					
				<input type="text" 
					name="<%= props.getProperty("parLocalidad") %>" 
					id="<%= props.getProperty("parLocalidad") %>"
					value="<%= empleado.getLocalidad() %>"
					size="20"
					class="form-control"
					placeholder="Telefono del alumno"
					 />
			</div>
			
			<div class="form-group">
				<label for="<%= props.getProperty("parCodigoPostal") %>">Codigo Postal: </label>
					
				<input type="text" 
					name="<%= props.getProperty("parCodigoPostal") %>" 
					id="<%= props.getProperty("parCodigoPostal") %>"
					value="<%= empleado.getCodigoPostal() %>"
					size="20"
					class="form-control"
					placeholder="Telefono del alumno"
					 />
			</div>

			<div class="form-group">
				<input type="submit" value="<%= tGuardar %>" class="btn btn-success" />
			</div>
		</form>
	<%
	}
	%>
	
</main>

<%@ include file="/includes/footer.jsp" %>