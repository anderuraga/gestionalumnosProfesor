<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.pojo.Empleado"%>
<%@page import="com.ipartek.formacion.service.EmpleadoServiceImp"%>
<%@page import="com.ipartek.formacion.service.EmpleadoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gestion Empleados</title>
	</head>
	
	<body>
		<%
		EmpleadoService eService = new EmpleadoServiceImp().getInstance();
		List<Empleado> empleados = (List<Empleado>) eService.getAll();
		
		if(empleados!=null){
			for(Empleado empleado: empleados){
				%>
				
				<p>Codigo: <%= empleado.getCodigo()%></p>
				<p>Nombre: <%= empleado.getNombre()%></p>
				<p>Apellidos: <%= empleado.getApellidos()%></p>
				<%
			}
		}
		
		%>
	</body>
</html>