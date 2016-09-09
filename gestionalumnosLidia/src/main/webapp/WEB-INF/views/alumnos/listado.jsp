<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp" />

<h2>LISTADO DE ALUMNOS</h2>
<div class="row">
	<div class="col-xs-12 col-sm-6">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>C�digo</th>
					<th>Nombre / Apellidos</th>
					
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty listaAlumnos}">
						<c:forEach items="${listaAlumnos }" var="alumno">
							<tr>
								<td>${alumno.codigo }</td>
								<td>${alumno.nombre },${alumno.apellidos }</td>
								<td><a href="<c:url value='/alumnos/${alumno.codigo }'/>" class="btn btn-warning">Editar
										</a></td>
								<td><form method="POST" action="<c:url value='/alumnos/${alumno.codigo }'/>">
										<button type="submit" class="btn btn-danger">
											Borrar
										</button>
									</form></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="2">No se han encontrado alumnos en la BBDD</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>