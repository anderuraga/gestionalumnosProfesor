<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ipartek.formacion.dao.persistencia.Candidato"%>
<%@page import="java.util.List"%>

<jsp:include page="../includes/header.jsp" />


<%
	List<Candidato> candidatos = (List<Candidato>) request.getAttribute("listado-candidatos");
		if (candidatos.size() > 0) {
	for (Candidato candidato : candidatos) {
		out.print("<p>" + candidato.getNombre() + " " + candidato.getApellidos()+ " <a href='candidatos/" + candidato.getCodigo() + "'><button type='button' class='btn btn-warning'>Modificar</button></a> <a href='" + candidato.getCodigo() + "/delete'><button type='button' class='btn btn-danger'>Eliminar</button></a></p>");

	}
		} else {
%>
<!-- Mensaje de tabla vacia -->
<p>No se han encontrado elementos en la BBDD</p>
<%
	}
		out.print("numero de candidatos "+ candidatos.size());
		%>
</body>
</html>