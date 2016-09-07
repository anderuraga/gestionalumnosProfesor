<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp" />

<h2>LISTADO ALUMNOS</h2>
<div class="row">
	<div class="col-xs-12 col-sm-6">
		<table class="table">
			<thead>
				<tr>
					<th>CODIGO</th>
					<th>NOMBRE Y APELLIDOS</th>
					<th>EDITAR</th>
					<th>ELIMINAR</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty listaAlumnos}">
						<c:forEach items="${listaAlumnos }" var="alumno">
							<tr>
								<td>${alumno.codigo }</td>
								<td>${alumno.nombre },${alumno.apellido }</td>
								<td><a href="<c:url value='/alumnos/${alumno.codigo }'/>"
									class="btn btn-warning"><i
										class="glyphicon glyphicon-pencil"></i></a></td>
								<td><form method="POST"
										action="<c:url value='/alumnos/${alumno.codigo }'/>">
										<button type="submit" class="btn btn-danger">
											<i class="glyphicon glyphicon-remove"></i>
										</button>
									</form></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="2">No se ha encontrado ningun alumno en la
								BBDD.</td>
						</tr>
					</c:otherwise>
				</c:choose>
				<tr><td colspan="4"><a href="<c:url value='/alumnos/addAlumno'/>" class="btn btn-success">A�adir</a></td></tr>
			</tbody>
		</table>
	</div>
</div>

</body>
</html>