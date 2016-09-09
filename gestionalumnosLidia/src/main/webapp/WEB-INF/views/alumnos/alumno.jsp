<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">

	<div class="col-xs-12 col-sm-6">
		<form:form action="save" method="post" commandName="alumno">
			<c:if test="${!empty alumno }">
				<form:hidden path="codigo" />
			</c:if>
			<div class="form-group">
				<form:label path="nombre">
					<spring:message text="Nombre:" />
				</form:label>
				<form:input path="nombre" cssClass="form-control" cssErrorClass=""/>
				<form:errors cssClass="text-danger" path="nombre" />
			</div>
			<div class="form-group">
				<form:label path="apellidos">
					<spring:message text="Apellidos:" />
				</form:label>
				<form:input path="apellidos" cssClass="form-control" cssErrorClass=""/>
				<form:errors cssClass="text-danger" path="apellidos" />
			</div>

			<div class="form-group">
			<a href="<c:url value='/alumnos'/>" class="btn btn-danger">Volver</a>
			
				<c:set var="msgBoton" value="Crear" />
				<c:if test="${alumno.codigo > 0}">
					<c:set var="msgBoton" value="Editar" />
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