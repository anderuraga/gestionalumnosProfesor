<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<jsp:include page="../includes/header.jsp" />
<main>
<div class="row">
	<div class="col-xs-12">
		<form:form action="saveModulo" commandName="modulo">
			<c:if test="${modulo.codigo > 0}">
				<div class="col-xs-6">
					<form:label path="codModulo">
						<spring:message text="Codigo" />
					</form:label>
					<form:input path="codModulo" readonly="true" disabled="" />
					<form:hidden path="codModulo" />
				</div>
			</c:if>
			<div class = col-xs-6>
				<form:label path="nombre">
					<spring:message text="Nombre" />
				</form:label>
				<form:input path="nombre" />
				<form:hidden path="nombre" />
			</div>

		</form:form>
	</div>
</div>

</main>
<jsp:include page="../includes/footer.jsp" />