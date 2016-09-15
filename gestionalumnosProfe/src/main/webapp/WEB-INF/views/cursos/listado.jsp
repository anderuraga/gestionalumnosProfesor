<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp" />
<h2>LISTADO CURSOS</h2>
<div class="row">
	<div class="col-xs-12 col-sm-6">
		<table class="table">
			<thead>
				<tr>
					<th>CODIGO</th>
					<th>NOMBRE DEL CURSO</th>
					<th>EDITAR</th>
					<th>ELIMINAR</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty listaCursos}">
						<c:forEach items="${listaCursos }" var="curso">
							<tr>
								<td>${curso.codigo }</td>
								<td>${curso.nombre }</td>
								<td><a href="<c:url value='/cursos/${curso.codigo }'/>" class="btn btn-warning"><i
										class="glyphicon glyphicon-pencil"></i></a></td>
								<td><form method="POST" action="<c:url value='/cursos/${curso.codigo }'/>">
										<button type="submit" class="btn btn-danger">
											<i class="glyphicon glyphicon-remove"></i>
										</button>
									</form></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="2">No se ha encontrado ningun curso en la BBDD.</td>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr><td colspan="4"><a href='<c:url value="/cursos/addCurso" />' class="btn btn-success">AÑADIR</a></td></tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>