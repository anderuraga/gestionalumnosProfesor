<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">
	<div class="col-xs-12 col-sm-6">
		<form:form method="POST" action="save" commandName="curso">
			<c:if test="${!empty curso }">
				<form:label path="codigo">
					<spring:message text="Codigo:" />
				</form:label>
				<form:input path="codigo" readonly="true" size="10" disabled="true"
					cssClass="form-control" />
				<form:hidden path="codigo" />
			</c:if>
			<div class="form-group">
				<form:label path="nombre">
					<spring:message text="Nombre:" />
				</form:label>
				<form:input path="nombre" cssClass="form-control" cssErrorClass=""/>
				<form:errors path="nombre" cssClass="text-danger"></form:errors>
			</div>
			<div class="form-group">
				<a href="<c:url value='/cursos'/>" class="btn btn-danger">ATRAS</a>
				<c:set var="msgBoton" value="CREAR" />
				<c:if test="${curso.codigo > 0}">
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