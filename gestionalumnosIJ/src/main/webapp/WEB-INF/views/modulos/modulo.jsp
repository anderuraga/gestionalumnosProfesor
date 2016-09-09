<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="../includes/header.jsp" />
<div class="row">
	<div class="col-xs-12 col-sm-6">
		<form:form method="POST" action="save" commandName="modulo">
			<c:if test="${!empty modulo }">
				<%-- 				<form:label path="codigo"> --%>
				<%-- 					<spring:message text="Codigo:" /> --%>
				<%-- 				</form:label> --%>
				<%-- 				<form:input path="codigo" readonly="true" size="10" disabled="true" --%>
				<%-- 					cssClass="form-control" /> --%>
				<form:hidden path="codigo" />
			</c:if>
			<div class="form-group">
				<form:label path="nombre">
					<spring:message text="Nombre:" />
				</form:label>
				<form:input path="nombre" cssClass="form-control" />
				<form:errors path="nombre" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<form:label path="duracion">
					<spring:message text="Duracion:" />
				</form:label>
				<form:select path="duracion" cssClass="form-control">
					<form:option value="1" label="15" />
					<form:option value="2" label="20" />
					<form:option value="3" label="45" />
					<form:option value="4" label="80" />
					<form:option value="5" label="90" />
				</form:select>
				<form:errors path="duracion" cssClass="text-danger" />
			</div>
			<div class="form-group">
				<a href="<c:url value='/modulos'/>" class="btn btn-danger">ATRAS</a>
				<c:set var="msgBoton" value="CREAR" />
				<c:if test="${modulo.codigo > 0}">
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