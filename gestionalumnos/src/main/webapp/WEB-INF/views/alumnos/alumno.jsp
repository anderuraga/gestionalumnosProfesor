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

<form:form action="save" commandName="alumno">
	<c:if test="${alumno.codigo > 0}">
		<div>
			<form:label path="codigo">
				<spring:message text="codigo" /><!-- para usar i18n, cambiar text por code y en codigo usar la property creada -->
			</form:label>
			<form:input path="codigo" readonly="true" size="10" disabled="" />
			<form:hidden path="codigo" />
		</div>
	</c:if>
	<div>
		<form:label path="nombre">
			<spring:message text="Nombre: " />
		</form:label>
		<form:input path="nombre" readonly="" size="10" disabled="" cssErrorClass=""/>
		<form:errors cssClass="" path="nombre" />
	</div>
	<div>
		<form:label path="apellidos">
			<spring:message text="Apellidos: " />
		</form:label>
		<form:input path="apellidos" readonly="" size="10" disabled="" cssErrorClass="" />
		<form:errors cssClass="" path="apellidos" />
	</div>
	<div>
		<form:label path="fNacimiento" cssClass="sr-only">
			<spring:message text="Fecha de Nacimiento: " />
		</form:label>
		<form:input path="fNacimiento" placeholder="dd/MM/yyyy" readonly="" size="10" disabled="" cssErrorClass="" />
		<form:errors cssClass="" path="fNacimiento" />
	</div>
	<div>
		<c:if test="${alumno.codigo > 0}">
			<button class="col-xs-2 btn btn-success">Editar alumno</button>
		</c:if>
		<c:if test="${alumno.codigo < 0}">
			<button class="col-xs-2 btn btn-success">Crear alumno</button>
		</c:if>
	</div>

</form:form>

<jsp:include page="../includes/footer.jsp" />