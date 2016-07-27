<%@page import="java.util.List"%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

<main>
	<%
		Empleado empleado = (Empleado) request.getAttribute(Constantes.ATT_ALUMNO);
		int op = -1;
		String tGuardar = "";
		if(empleado!=null){
			tGuardar = "guardar";
			op = Constantes.OP_UPDATE;
		}else{
			op = Constantes.OP_CREATE;
			tGuardar ="crear nuevo";
			empleado = new Empleado();
		}
	%>
		<a href="<%=Constantes.SERVLET_EMPLEADOS%>">Atras</a>


		
		<%
		if(empleado!=null){
			%>
				<form name="" id="" method='post' class="form-horizontal"
					action="<%=Constantes.SERVLET_EMPLEADOS%>">
					<input type="hidden" 
						id="<%=Constantes.PAR_OPERACION %>"
						name="<%=Constantes.PAR_OPERACION %>"  
						value="<%=op %>"/>
					<input type="hidden" 
						id="<%=Constantes.PAR_CODIGO %>" 
						name="<%=Constantes.PAR_CODIGO %>" 
						value="<%=empleado.getCodigo()%>"/>
					<div class="form-group">
						<label class="col-xs-2" for="<%=Constantes.PAR_NOMBRE%>">Nombre:</label>
						<div class="col-xs-10">
						<input type="text" class="form-control"
							name="<%=Constantes.PAR_NOMBRE%>" 
							id="<%=Constantes.PAR_NOMBRE%>" 
							value="<%=empleado.getNombre() %>"
							/>
						</div>
						<span class="alert alert-danger hide"></span>
					</div>
					<div class="form-group">
						<label class="col-xs-2" for="<%=Constantes.PAR_APELLIDOS%>">Apellidos:</label>
						<div class="col-xs-10">					
						<input type="text"  class="form-control"
							name="<%=Constantes.PAR_APELLIDOS%>" 
							id="<%=Constantes.PAR_APELLIDOS%>" 
							value="<%=empleado.getApellidos() %>"
							/>
							</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2" for="<%=Constantes.PAR_DNI%>">Dni:</label>
						<div class="col-xs-10">
						<input type="text" pattern="((([A-Z]|[a-z])\d{8})|(\d{8}([A-Z]|[a-z])))"
							name="<%=Constantes.PAR_DNI%>" class="form-control"
							id="<%=Constantes.PAR_DNI%>" 
							value="<%=empleado.getDni() %>"
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
									<input type="number"  value="<%=calendar.get(GregorianCalendar.DAY_OF_MONTH) %>" class="form-control" min="1" max="31" step="1" name="<%=Constantes.PAR_DIA%>"	/>
								</div>
								<div class="col-xs-3">
										<label for="">Mes:</label>
										<input type="number" value="<%=calendar.get(GregorianCalendar.MONTH)+1 %>" class="form-control" min="1" max="12" step="1" name="<%=Constantes.PAR_MES%>"	/>
									
								</div>
								<div class="col-xs-6">
									<label for="">Año:</label>
									<input type="number"  value="<%=calendar.get(GregorianCalendar.YEAR) %>" class="form-control" min="" max="" name="<%=Constantes.PAR_ANYO%>"	/>
								</div>
							</div>
						</div> 
					</div>
					<div class="form-group">
						<label class="col-xs-2">Idiomas:</label>
						<div class="col-xs-10">
					
							<input type="checkbox" name="<%=Constantes.PAR_IDIOMA %>" id=""
								<%= empleado.getIdiomas().contains(Idioma.CASTELLANO) ? "checked" : "" %> 
								 value="<%=Idioma.CASTELLANO.getCodigo() %>"/> 
								<%=Idioma.CASTELLANO.getNombre() %>
							<input type="checkbox" name="<%=Constantes.PAR_IDIOMA %>" id="" 
								<%= empleado.getIdiomas().contains(Idioma.EUSKERA) ? "checked" : "" %>
								value="<%=Idioma.EUSKERA.getCodigo() %>"/> 
								<%=Idioma.EUSKERA.getNombre() %>
							<input type="checkbox" name="<%=Constantes.PAR_IDIOMA %>" id="" 
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