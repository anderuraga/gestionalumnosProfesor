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
					<spring:message code="alumno.nombre" />:
				</form:label>
				<form:input path="nombre" cssClass="form-control" cssErrorClass="" />
				<form:errors cssClass="text-danger" path="nombre" />
			</div>
			<div class="form-group">
				<form:label path="apellido">
					<spring:message text="Apellidos:" />
				</form:label>
				<form:input path="apellido" cssClass="form-control" cssErrorClass="" />
				<form:errors cssClass="text-danger" path="apellido" />
			</div>
			<div class="form-group">
				<form:label path="fNacimiento">
					<spring:message text="Fecha de Nacimiento:" />
				</form:label>
				<form:input path="fNacimiento" placeholder="dd/MM/yyyy"
					cssClass="form-control" cssErrorClass=""
					pattern="[0-9]{2}/[0-9]{2}/[0-9]{4}" />
				<form:errors cssClass="text-danger" path="fNacimiento" />
			</div>
			<div class="form-group">
				<form:label path="email">
					<spring:message text="E-mail:" />
				</form:label>
				<form:input path="email" cssClass="form-control" cssErrorClass="" />
				<form:errors cssClass="text-danger" path="email" />
			</div>
			<!-- 			<div class="form-group"> -->
			<%-- 				<form:label path="telefono"> --%>
			<%-- 					<spring:message text="Telefono:" /> --%>
			<%-- 				</form:label> --%>
			<%-- 				<form:input  path="telefono" cssClass="form-control" cssErrorClass=""/> --%>
			<%-- 				<form:errors cssClass="" path="telefono" /> --%>
			<!-- 			</div> -->
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