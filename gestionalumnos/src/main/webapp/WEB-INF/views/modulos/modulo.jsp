<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<spring:url value="/resources/css/bootstrap.min.css" var="cssBootstrap" />
<spring:url value="css/font-awesome.min.css" var="cssFont" />
<spring:url value="css/styles.css" var="cssStyle"/>
    
<jsp:include page="../includes/header.jsp"/><!-- Aqui se compila previamente, tiene codigo java, se tiene que meter en el include.
Esto hace que tarde más en cargar, pero puede ser interesante a la larga -->

<form:form action="save" commandName="modulo">
	<c:if test="${modulo.codigo > 0}">
		<div>
			<form:label path="codModulo">
				<spring:message text="codigo" />
			</form:label>
			<form:input path="codigo" readonly="true" size="10" disabled="true" cssErrorClass="" />
			<form:errors cssClass="" path="codigo" />
			<form:hidden path="codigo" />
		</div>
	</c:if>
	<div>
		<form:label path="nombre">
			<spring:message text="Nombre" />
		</form:label>
		<form:input path="nombre" readonly="" size="10" disabled="" cssErrorClass="" />
		<form:errors cssClass="" path="nombre" />
		
	</div>
	<div>
		<form:label path="uFormativa">
			<spring:message text="Unidad formativa: " />
		</form:label>
		<form:input path="uFormativa" readonly="" size="10" disabled="" cssErrorClass="" />
		<form:errors cssClass="" path="uFormativa" />
		
	</div>
	<div>
		<form:label path="duracion">
			<spring:message text="Duracion: " />
		</form:label>
		<form:input path="duracion" readonly="" size="10" disabled="" cssErrorClass="" />
		<form:errors cssClass="" path="duracion" />
	</div>


	<div>
		<c:if test="${modulo.codigo > 0}">
			<input type="submit" value="<spring:message text="Editar modulo"/>" />
		</c:if>
		<c:if test="${modulo.codigo < 0}">
			<input type="submit" value="<spring:message text="Crear modulo"/>" />
		</c:if>
	</div>

</form:form>

<jsp:include page="../includes/footer.jsp" />