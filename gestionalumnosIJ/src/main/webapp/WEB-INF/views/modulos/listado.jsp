<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp" />
<h2>LISTADO MODULOS</h2>
<div class="row">
	<div class="col-xs-12 col-sm-6">
		<table class="table">
			<thead>
				<tr>
					<th>CODIGO</th>
					<th>NOMBRE DEL MODULO</th>
					<th>EDITAR</th>
					<th>ELIMINAR</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty listaModulos}">
						<c:forEach items="${listaModulos }" var="modulo">
							<tr>
								<td>${modulo.codigo }</td>
								<td>${modulo.nombre }</td>
								<td><a href="<c:url value='/modulos/${modulo.codigo }'/>" class="btn btn-warning"><i
										class="glyphicon glyphicon-pencil"></i></a></td>
								<td><form method="POST" action="<c:url value='/modulos/${modulo.codigo }'/>">
										<button type="submit" class="btn btn-danger">
											<i class="glyphicon glyphicon-remove"></i>
										</button>
									</form></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="2">No se ha encontrado ningun modulo en la BBDD.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>