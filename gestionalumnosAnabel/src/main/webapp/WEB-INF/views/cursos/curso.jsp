<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<jsp:include page="../includes/header.jsp" />
<main>
<div class="row">
	<div class="col-xs-12">
		<form:form class="form-horizontal" action="saveCurso"
			commandName="curso">
			<c:if test="${curso.codigo >0}">
				<div class="form-group">
					<div class="col-xs-12">
						<form:label path="codigo">
							<spring:message text="Codigo" />
						</form:label>
						<form:input path="codigo" readonly="true" size="10" disabled="" />
						<form:hidden path="codigo" />
					</div>
				</div>
			</c:if>
			<div class="form-group">
				<div class="col-xs-12">
					<form:label path="nombre">
						<spring:message text="Nombre" />
					</form:label>
					<form:input path="nombre" placeholder="Nombre"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-12">
					<c:if test="${curso.codigo > 0}">
						<input class="btn btn-default" type="submit" value="<spring:message text="Editar curso"/>" />
					</c:if>
					<c:if test="${curso.codigo < 0}">
						<input class="btn btn-default" type="submit" value="<spring:message text="Crear curso"/>" />
					</c:if>
				</div>
			</div>
		</form:form>
	</div>
</div>
</main>
<jsp:include page="../includes/footer.jsp" />