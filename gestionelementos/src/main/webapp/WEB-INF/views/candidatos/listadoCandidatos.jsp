<%@page import="com.ipartek.formacion.dao.persistence.Candidato"%>
<%@page import="java.util.List"%>
<jsp:include page="../includes/header.jsp" />
<%
		List<Candidato> candidatos = (List<Candidato>) request.getAttribute("listado-candidatos");
		if (candidatos.size() > 0) {
			for (Candidato candidato : candidatos) {
				out.print("<p>" + candidato.getNombre() + " " + candidato.getApellidos() + "</p>");

			}
		} else {
	%>
	<!-- Mensaje de tabla vacia -->
	<p>No se han encontrado elementos en la BBDD</p>
	<%
		}
	%>
	</body>
</html>