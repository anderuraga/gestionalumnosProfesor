<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">
	<div class="col-xs-12 col-sm-6">
		<form method="POST" action="<c:url value='/modulos'/>">
			<div class="form-group">
				<label for="codigo">CODIGO</label> <input type="text" id="codigo" name="codigo"
					class="form-control" value="${modulo.codigo }" />
			</div>
			<div class="form-group">
				<label for="nombre">NOMBRE</label> <input type="text" id="nombre" name="nombre"
					class="form-control" value="${modulo.nombre }" />
			</div>
			<a href="<c:url value='/modulos'/>" class="btn btn-danger">CANCELAR</a>
			<button type="submit" class="btn btn-success">ENVIAR</button>

		</form>
	</div>
</div>
</body>
</html>