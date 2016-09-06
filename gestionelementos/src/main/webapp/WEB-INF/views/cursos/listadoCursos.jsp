<%@page import="com.ipartek.formacion.dao.persistence.Curso"%>
<%@page import="java.util.List"%>
<jsp:include page="../includes/header.jsp" />
<%
		List<Curso> cursos = (List<Curso>) request.getAttribute("listado-cursos");
		if (cursos.size() > 0) {
			for (Curso curso : cursos) {
				out.print("<p>" + curso.getNombre() + "</p>");

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