<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<p><b>Listado de Alumnos:</b></p>
		
		<%
			List<Alumno> alumnos = (List<Alumno>) request.getAttribute("listado-alumnos");
			if(alumnos.size()>0){
				for(Alumno alumno: alumnos){
					out.print("<p>" + alumno.getNombre() + " " + alumno.getApellidos() + "</p>");
				}
			} else{
				%>
					<p>No se han encontrado alumnos en la Base de Datos.</p>
				<%
			}
		%>

</body>
</html>