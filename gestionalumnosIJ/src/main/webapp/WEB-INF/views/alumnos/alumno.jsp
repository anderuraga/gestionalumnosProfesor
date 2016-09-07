<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">

	<div class="col-xs-12 col-sm-6">
		<form:form action="save" method="post" commandName="alumno">
			<c:if test="${!empty alumno }">
				<form:label path="codigo">
					<spring:message text="Codigo:" />
				</form:label>
				<form:input path="codigo" readonly="true" size="10" disabled="true" cssClass="form-control" />
				<form:hidden path="codigo" />
			</c:if>
			<div class="form-group">
				<form:label path="nombre">
					<spring:message text="Nombre:" />
				</form:label>
				<form:input path="nombre" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="apellido">
					<spring:message text="Apellidos:" />
				</form:label>
				<form:input path="apellido" cssClass="form-control" />
			</div>
			<div class="form-group">
			<a href="<c:url value='/alumnos'/>" class="btn btn-danger">ATRAS</a>
				<c:set var="msgBoton" value="CREAR" />
				<c:if test="${alumno.codigo > 0}">
					<c:set var="msgBoton" value="EDITAR" />
				</c:if>
				<button type="submit" class="btn btn-success">
					<spring:message text="${msgBoton}" />
				</button>
			</div>
		</form:form>
	</div>
</div>

</body>
</html>