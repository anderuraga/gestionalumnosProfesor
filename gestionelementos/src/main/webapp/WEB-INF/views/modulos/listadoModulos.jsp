<%@page import="com.ipartek.formacion.dao.persistence.Modulo"%>
<%@page import="java.util.List"%>
<jsp:include page="../includes/header.jsp" />
<%
		List<Modulo> modulos = (List<Modulo>) request.getAttribute("listado-modulos");
		if (modulos.size() > 0) {
			for (Modulo modulo : modulos) {
				out.print("<p>" + modulo.getNombre() + "</p>");

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