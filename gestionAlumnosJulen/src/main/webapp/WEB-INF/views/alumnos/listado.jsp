<%@page import="com.ipartek.formacion.dao.persistence.Alumno"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />
<% 

	List<Alumno> alumnos = (List<Alumno>) request.getAttribute("listadoAlumnos");
	if(alumnos.size()>0)
	{
		for(Alumno alumno: alumnos)
		{
			out.print("<p>"+alumno.getNombre() +" " + alumno.getApellidos()+"</p>");
		}
	}
	else
	{
		%>
		No se han encontrado alumnos en la BBDD
		<%
	}
	%>
</body>
</html>