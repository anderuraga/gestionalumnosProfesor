
<%@page import="java.util.Properties"%>
<%@page import="com.ipartek.formacion.pojo.Departamento"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<main>
	<% 

	List<Departamento> departamentos;
	String formulario;
	departamentos = (List<Departamento>) request.getAttribute("${properties.listadoDepartamento}");
	if(departamentos!=null){
		int i=1;
		for (Departamento departamento: departamentos)
		{
			//inicio el form del boton para borrar
			formulario ="<form action='${properties.servletEmpleado}' method='post'>";
			//Aqui variables para borrar 
			formulario += "<input type='hidden' name='${properties.parOperacion}' value='${properties.opDelete}'/>";
			//Aqui codigo para borrar
			formulario += "<input type='hidden' name='${properties.parCodigo}' value='"+departamento.getCodigo()+"'/>";
			//Aqui el boton
			formulario += "<button type='submit' class='btn btn-danger'><span class='fa fa-trash-o' aria-hidden='true'></span> Borrar </button>";
			//El cierre del form
			formulario +="</form>";
			%>
			<div class="row">
				<a class="col-xs-10 btn btn-success" href="${properties.servletDepartamento}?${properties.parCodigo}=${properties.codigo}">"<%=departamento.getNombre() %>" </a><%=formulario %>
			</div>
	<%
		}
	}	else{
		out.write("falla listado departamentos");
		
	}
	%> 
	
	<%-- Scriptlets --%>
	<a class="btn btn-success" href="${properties.servletDepartamento}?${properties.parCodigo}=${Departamento.CODIGO_DEPARTAMENTO}"><span class="fa fa-plus fblack" aria-hidden="true"></span> Departamento</a>	
	<a class="btn btn-info" href="index.jsp">Página principal</a>
</main>
<%@include file="../includes/footer.jsp" %>