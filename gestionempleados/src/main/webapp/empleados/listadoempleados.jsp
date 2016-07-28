
<%@page import="java.util.Properties"%>
<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<main>
	<% 

	List<Empleado> empleados;
	String formulario;
	empleados = (List<Empleado>) request.getAttribute("${properties.listadoEmpleado}");
	if(empleados!=null){
		int i=1;
		for (Empleado empleado: empleados)
		{
			//inicio el form del boton para borrar
			formulario ="<form action='${properties.servletEmpleado}' method='post'>";
			//Aqui variables para borrar 
			formulario += "<input type='hidden' name='${properties.parOperacion}' value='${properties.opDelete}'/>";
			//Aqui codigo para borrar
			formulario += "<input type='hidden' name='${properties.parCodigo}' value='"+empleado.getCodigo()+"'/>";
			//Aqui el boton
			formulario += "<button type='submit' class='btn btn-danger'><span class='fa fa-trash-o' aria-hidden='true'></span> Borrar </button>";
			//El cierre del form
			formulario +="</form>";
			%>
			<div class="row">
				<a class="col-xs-10 btn btn-success" href="${properties.servletEmpleado}?${properties.parCodigo}=${properties.codigo}">"<%=empleado.getNombre() %>" </a><%=formulario %>
			</div>
	<%
		}
	}	else{
		out.write("falla listado empleado");
		
	}
	%> 
	
	<%-- Scriptlets --%>
	<a class="btn btn-success" href="${properties.servletEmpleado}?${properties.parCodigo}=${Empleado.CODIGO_EMPLEADO}"><span class="fa fa-plus fblack" aria-hidden="true"></span> Empleado</a>	
	<a class="btn btn-info" href="index.jsp">Página principal</a>
</main>
<%@include file="../includes/footer.jsp" %>