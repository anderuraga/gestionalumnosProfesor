
<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>
<main>
	<% 
	List<Empleado> empleados;
	String formulario;
	empleados = (List<Empleado>) request.getAttribute(Constantes.ATT_LISTADO_EMPLEADOS);
	if(empleados!=null){
		int i=1;
		for (Empleado empleado: empleados)
		{
			//inicio el form del boton para borrar
			formulario ="<form action='"+Constantes.SERVLET_EMPLEADOS+"' method='post'>";
			//Aqui variables para borrar 
			formulario += "<input type='hidden' name='"+Constantes.PAR_OPERACION+"' value='"+Constantes.OP_DELETE+"'/>";
			//Aqui codigo para borrar
			formulario += "<input type='hidden' name='"+Constantes.PAR_CODIGO+"' value='"+empleado.getCodigo()+"'/>";
			//Aqui el boton
			formulario += "<button type='submit' class='btn btn-danger'><span class='fa fa-trash-o' aria-hidden='true'></span> Borrar </button>";
			//El cierre del form
			formulario +="</form>";
			%>
			<div class="row">
				<a class="col-xs-10 btn btn-success" href="<%=Constantes.SERVLET_EMPLEADO+"?"+Constantes.PAR_CODIGO+"="+empleado.getCodigo() %>">"<%=empleado.getNombre() %>" </a><%=formulario %>
			</div>
	<%
		}
	}	else{
		out.write("falla listado empleado");
		
	}
	%> 
	
	<%-- Scriptlets --%>
	<a class="btn btn-success" href="<%=Constantes.SERVLET_EMPLEADO+"?"+Constantes.PAR_CODIGO+"="+EMPLEADO.CODIGO_EMPLEADO%>"><span class="fa fa-plus fblack" aria-hidden="true"></span> Empleado</a>	
	<a class="btn btn-info" href="index.jsp">Página principal</a>
</main>
<%@include file="../includes/footer.jsp" %>