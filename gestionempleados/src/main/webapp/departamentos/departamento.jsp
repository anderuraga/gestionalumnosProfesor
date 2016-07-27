<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@page import="java.util.Map"%>
<%@page import="com.ipartek.formacion.controller.Constantes"%>
<%@page import="com.ipartek.formacion.pojo.Departamento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"/>	
<main>
		<%
		Departamento departamento = (Departamento) request.getAttribute(Constantes.ATT_DEPARTAMENTO);
		int op = -1;
		String tGuardar = "";
		if(departamento!=null){
			op = Constantes.OP_UPDATE;
			tGuardar ="guardar";
		}else{

			departamento = new Departamento();
			op = Constantes.OP_CREATE;
			tGuardar = "Crear";
		}
		%>
		<a class="btn btn-warning" href="${properties.servletDepartamento}">Atrás</a>

		
		<%
		if(departamento!=null){
		%>
		${properties.servletDepartamento }
			<form name="formdepartamento" class="" id="formdepartamento" method='post' 
				action="${properties.servletDepartamento }">
				<input type="hidden" 
					id="${properties.parOperacion }"
					name="${properties.parOperacion }"  
					value="<%=op %>"/>
				<input type="hidden" 
					id="${properties.parCodigo }" 
					name="${properties.parCodigo }" 
					value="${departamento.codigo}"/>
				<div class="form-group">
					<label class="sr-only" for="${properties.parNombre }">Nombre: </label>
					<input  type="text" class="form-control "
					placeholder="Indrodruzca el nombre del Curso"
						name="${properties.parNombre }" 
						id="${properties.parNombre }" 
						value="${departamento.nombre}"
						/>
					
				</div>
			



				<div class="form-group ">
					<label class="col-xs-2">Empleados:</label>
					<div class="col-xs-10">
					<%
					List<Empleado> empleados =  (List<Empleado>)request.getAttribute(Constantes.ATT_LISTADO_EMPLEADOS);
					if(empleados!=null && empleados.size()>0){
						for(Empleado empl: empleados){
							%>
							<input <%= departamento.getEmpleados().containsKey(empl.getDni()) ? "checked" :""%> 
								type="checkbox" name="${properties.listadoEmpleados}" 
								value="${empl.codigo}"
								/> ${empl.nombre} +" "+${empl.apellidos}
							<%
						}
					}else{
						%>
						No hay empleados.
						<%
					}
					%>
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-2">Total Empleados:</label>
					<div class="col-xs-10">
					<%= departamento.getEmpleados().size() %> Empleados
					</div>
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-success">
						<%=tGuardar %>
					</button>
				</div>
			</form>			
	<%	}
		%>
</main>
<%@ include file="../includes/footer.jsp" %>