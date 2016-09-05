<%@page import="com.ipartek.formacion.dao.persistence.Curso"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<jsp:include page="../include/header.jsp" />
<% 

	List<Curso> cursos = (List<Curso>) request.getAttribute("listaCursos");
	if(cursos.size()>0)
	{
		for(Curso curso: cursos)
		{
			out.print("<p>"+curso.getCodigo() +"--->" + curso.getNombre()+"</p>");
		}
	}
	else
	{
		%>
		No se han encontrado Cursos en la BBDD
		<%
	}
	%>
</body>
</html>