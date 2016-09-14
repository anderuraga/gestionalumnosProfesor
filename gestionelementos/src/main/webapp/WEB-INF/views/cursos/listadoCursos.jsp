<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ipartek.formacion.dao.persistence.Curso"%>

<%@page import="java.util.List"%>

<jsp:include page="../includes/header.jsp" />

<%
		List<Curso> cursos = (List<Curso>) request.getAttribute("listado-cursos");
		if (cursos.size() > 0) {
			for (Curso curso : cursos) {
				out.print("<p>"+ curso.getNombre() + " <a href='cursos/" + curso.getCodigo() +"'><button type='button' class='btn btn-warning'>Modificar</button></a> <a href='#'><button type='button' class='btn btn-danger'>Eliminar</button></a></p>");
			}
		} else {
	%>
	<!-- Mensaje de tabla vacia -->
	<p>No se han encontrado elementos en la BBDD</p>
	<%
		}
		out.print("numero de cursos "+ cursos.size());
		%>
	</body>
</html>