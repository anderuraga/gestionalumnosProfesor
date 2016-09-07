<%@page import="com.ipartek.formacion.dao.persistence.Modulo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Modulos</title>
</head>
<body>

		<p><b>Listado de Modulos:</b></p>
		
		<%
			List<Modulo> modulos = (List<Modulo>) request.getAttribute("listado-modulos");
			if(modulos.size()>0){
				for(Modulo modulo: modulos){
					out.print("<p>" + modulo.getNombre() + "</p>");
				}
			} else{
				%>
				<p>No se han encontrado modulos en la Base de Datos.</p>
			<%
		}
		%>

</body>
</html>